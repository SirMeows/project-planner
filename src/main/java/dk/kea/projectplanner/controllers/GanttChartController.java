package dk.kea.projectplanner.controllers;

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

    @ModelAttribute
    public void ganttUtility(Model model) {
        if(gu == null) gu = new GanttUtility();
        model.addAttribute("gu", gu);
    }

    // URL params is always string, but spring is casting to int before entering method
    @GetMapping("/")
    public String gantt(@RequestParam(defaultValue = "0") int zoom, @RequestParam(defaultValue = "0") int page){
        if (gu.currentZoomLevel == null || !gu.currentZoomLevel.equals(gu.zoomLevels.get(zoom))) {
            gu.currentZoomLevel = gu.zoomLevels.get(zoom);
            gu.calcStartAndEndDate();
        }
        gu.currentPage = page;
        gu.updateHours();
        gu.hoursPage.clear();
        int hpp = gu.currentZoomLevel.calcHoursPerPage(page, gu.startDate);
        // TODO: check bounds and disable pagination

        gu.hoursPage.addAll(gu.getHoursToShow());
        System.out.println(gu.currentZoomLevel.getName());
        System.out.println(gu.startDate.toString());
        System.out.println(gu.endDate.toString());
        System.out.println(page);
        return "gantt-chart";
    }
}