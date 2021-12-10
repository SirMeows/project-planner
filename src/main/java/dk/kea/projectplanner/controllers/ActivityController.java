package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.models.ActivityModel;
import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.models.SubProjectModel;
import dk.kea.projectplanner.services.ActivityService;
import dk.kea.projectplanner.services.ProjectService;
import dk.kea.projectplanner.services.SubProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    // ActivityService<?> activityService;
    ProjectService projectService;
    SubProjectService subProjectService;
    ActivityModel subType;

    public ActivityController(ProjectService projectService, SubProjectService subProjectService) {
        this.projectService = projectService;
        this.subProjectService = subProjectService;
    }

    @GetMapping("/create")
    public String showForm(Model model, @RequestParam(defaultValue = "ProjectModel") String type) {
        try {
            this.subType = (ActivityModel) Class.forName("dk.kea.projectplanner.models." + type).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //System.out.println(subType instanceof ProjectModel);
        //System.out.println(subType instanceof SubProjectModel);
        model.addAttribute("type", type);
        model.addAttribute("activity", subType);
        return "create-activity";
    }

    // TODO: validation
    @PostMapping("/create")
    public String create(@ModelAttribute("activity") ProjectModel activity){
        System.out.println(activity instanceof ProjectModel);
        projectService.createProject(activity);
        return "redirect:/gantt/";
    }
}