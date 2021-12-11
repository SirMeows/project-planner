package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.models.ActivityModel;
import dk.kea.projectplanner.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            --level; // need parents
            System.out.println(level);
            model.addAttribute("activities", service.findAllByLevelId(level));
            String parentName = service.levelNameByLevelId(level);
            model.addAttribute("parentName", parentName);
        }
        model.addAttribute("activity", activity);
        model.addAttribute("level", level);
        return "create-activity";
    }

    // TODO: Add validation in all models used
    @PostMapping("/create")
    public String createActivity(@ModelAttribute("activity") ActivityModel activity){
        service.createActivity(activity);
        return "redirect:/gantt/";
    }
}