package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.util.GanttUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GanttChartController {

    GanttUtility gu = new GanttUtility();

    @GetMapping("/gantt-week")
    public String gantWeek(Model model){
        gu.colSize = 8;
        gu.zoomLevel = "week";
        model.addAttribute("gu", gu);
        return "gantt-chart";
    }

    @GetMapping("/gantt-month")
    public String gantMonth(Model model){
        gu.colSize = 2;
        gu.zoomLevel = "month";
        model.addAttribute("gu", gu);
        model.addAttribute("");
        return "gantt-chart";
    }
}