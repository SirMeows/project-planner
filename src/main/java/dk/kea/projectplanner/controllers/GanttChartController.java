package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.models.ActivityModel;
import dk.kea.projectplanner.services.ActivityService;
import dk.kea.projectplanner.util.GanttUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/gantt")
public class GanttChartController {

    GanttUtility gu;
    ActivityService activityService;
    List<ActivityModel> activities;
    long oldParent = 0;
    String level;

    public GanttChartController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @ModelAttribute
    public void ganttUtility(Model model) {
        if(gu == null) gu = new GanttUtility();
        model.addAttribute("gu", gu);
        activities = activityService.findAllByLevel(level);
    }

    // URL params is always string, but spring is casting to int before entering method
    @GetMapping("/")
    public String gantt(@RequestParam(defaultValue = "2") int zoom,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "0") long parent, Model model){

        setLevelAndActivities(parent);

        // recalculate columns initially and when zoom or parent changes
        if (gu.currentZoomLevel == null || !gu.currentZoomLevel.equals(gu.zoomLevels.get(zoom))
                || parent != oldParent) {
            oldParent = parent;
            gu.currentZoomLevel = gu.zoomLevels.get(zoom);
            if (!activities.isEmpty()) gu.updateColumns(zoom, activities);
        }
        if(!activities.isEmpty()) {
            gu.pagination.currentPage = page;
            gu.updateColumnsInPage();
        }
        model.addAttribute("level", level);
        model.addAttribute("activities", activities);
        return "gantt-chart";
    }

    private void setLevelAndActivities(long parent) {
        // expose children if parent is set // Todo: error handling
        if (parent > 0 && !activities.isEmpty()) {
            if (!activityService.findByParentId(parent).isEmpty()) {
                level = activityService.findByParentId(parent).get(0).getLevel();
                // System.out.println(level);
            } else { // no subactivities
                int l = activityService.levelIdByName(level);
                if (l < 3) l++;
                level = activityService.levelNameByLevelId(l);
            }
            activities = activityService.findByParentId(parent);
        } else { // parent or activities not set, use default level
            level = "Project";
            activities = activityService.findAllByLevel(level);
        }
    }
}