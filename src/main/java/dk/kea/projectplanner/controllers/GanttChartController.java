package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.util.GanttUtility;
import dk.kea.projectplanner.util.ZoomLevel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/gantt")
public class GanttChartController {

    GanttUtility gu;

    @ModelAttribute
    public void ganttUtility(Model model) {
        if(gu == null) gu = new GanttUtility();
        model.addAttribute("gu", gu);
        model.addAttribute("zoomLevels", Arrays.asList(ZoomLevel.values()));
    }

    @GetMapping("/day")
    public String gantDay(){
        gu.zoomLevel = ZoomLevel.DAY;
        return "gantt-chart";
    }

    @GetMapping("/week")
    public String gantWeek(){
        gu.zoomLevel = ZoomLevel.WEEK;
        return "gantt-chart";
    }

    @GetMapping("/month")
    public String gantMonth(){
        gu.zoomLevel = ZoomLevel.MONTH;
        gu.zoomLevelColSizeMap.get(ZoomLevel.MONTH);
        return "gantt-chart";
    }
}