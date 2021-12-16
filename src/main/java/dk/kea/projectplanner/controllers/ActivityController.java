package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.models.ActivityModel;
import dk.kea.projectplanner.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String showForm(Model model, @RequestParam(defaultValue = "0") int level) {
        ActivityModel activity = new ActivityModel(level); // Create activity at this level
        if (level > 0) { // if not project
            model.addAttribute("activities", service.findAllByLevelId(level-1));
            String parentName = service.levelNameByLevelId(level-1);
            model.addAttribute("parentName", parentName);
        }
        model.addAttribute("activity", activity);
        model.addAttribute("level", level);
        return "create-activity";
    }

    // TODO: Add validation
    @PostMapping("/create")
    public String createActivity(@ModelAttribute("activity") ActivityModel activity){
        service.createActivity(activity);
        return "redirect:/gantt/";
    }

    @GetMapping("/delete")
    public String deleteActivity(@RequestParam long id,
                                 @RequestParam(defaultValue="0") long parent,
                                 @RequestParam(defaultValue = "2") Integer zoom,
                                 RedirectAttributes attr){
        attr.addAttribute("parent", parent);
        attr.addAttribute("zoom", zoom);
        // delete activity and all subactivities recursively
        service.deleteActivityAndSubActivities(id);
        return "redirect:/gantt/";
    }
}