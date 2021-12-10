package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.services.ProjectService;
import dk.kea.projectplanner.util.GanttUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gantt")
public class GanttChartController {

    GanttUtility gu;
    ProjectService ps;

    public GanttChartController(ProjectService ps) {
        this.ps = ps;
    }

    @ModelAttribute
    public void ganttUtility(Model model) {
        if(gu == null) gu = new GanttUtility();
        model.addAttribute("gu", gu);
        System.out.println(ps.findAllProjects().get(4L).getName());
        model.addAttribute("activities",ps.findAllProjects().values());
    }

    // URL params is always string, but spring is casting to int before entering method
    @GetMapping("/")
    public String gantt(@RequestParam(defaultValue = "2") int zoom, @RequestParam(defaultValue = "0") int page){
        if (gu.currentZoomLevel == null || !gu.currentZoomLevel.equals(gu.zoomLevels.get(zoom))) {
            gu.currentZoomLevel = gu.zoomLevels.get(zoom);
            gu.calcStartAndEndColumn(ps.findAllProjects());
            gu.updateColumns();
        }
        gu.pagination.currentPage = page;
        gu.updateColumnsInPage();

        return "gantt-chart";
    }
}