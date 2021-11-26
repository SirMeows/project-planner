package dk.kea.projectplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GanttChartController {

    List<ActivityMockModel> activities = new ArrayList<>();


    @GetMapping("/")
    public String index(Model model){
        addPseudoActivities();
        model.addAttribute("activities", this.activities);
        model.addAttribute("colors",
                new String[]{"#b03532", "#33a8a5","#30997a","#6a478f","#da6f2b","#3d8bb1","#e03f3f","#59a627","#4464a1"});
        return "gantt-chart";
    }

    private List<ActivityMockModel> addPseudoActivities() {
        for (int i = 1; i<10; i+=2) {
            activities.add(new ActivityMockModel("Activity "+i, i, i+3));
        }
        return activities;
    }

}

class ActivityMockModel {

    private String name;
    private int startDate;
    private int endDate;

    public ActivityMockModel(String name, int startDate, int endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}