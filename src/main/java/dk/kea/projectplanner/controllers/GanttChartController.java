package dk.kea.projectplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class GanttChartController {

    GanttUtility gu = new GanttUtility();

    @GetMapping("/gantt-week")
    public String gantWeek(Model model){
        ActivityMockModel activity = gu.activities.get(0); // PRECONDITION: list must be sorted after startDate ascending
        LocalDateTime startDay = activity.getPlannedStartDate();
        List<String> dayShortNames = new ArrayList<>();
        for (DayOfWeek day : DayOfWeek.values())
        {
            dayShortNames.add( day.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toLowerCase() );
        }
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

class GanttUtility {

    public String zoomLevel;
    public int colSize;
    public LocalDateTime startDate, endDate;
    public String[] activityColors = new String[]{"#b03532", "#33a8a5","#30997a","#6a478f","#da6f2b","#3d8bb1","#e03f3f","#59a627","#4464a1"};
    public List<ActivityMockModel> activities = new ArrayList<>();
    public List<LocalDateTime> days = new ArrayList<>();
    public TextStyle txtStyle = TextStyle.SHORT;
    public Locale locale = Locale.ENGLISH;

    public GanttUtility() {
        addPseudoActivities();
        calcStartAndEndDate();
        populateDays();
    }

    public void populateDays() {
        for (LocalDateTime date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            this.days.add(date);
        }
    }

    public void calcStartAndEndDate() {
        LocalDateTime start = activities.get(0).getPlannedStartDate();
        LocalDateTime end = start;
        for (ActivityMockModel activity : activities) {
            if (activity.getPlannedStartDate().isBefore(start)) start = activity.getPlannedStartDate();
            if (activity.getDeadline().isAfter(end)) end = activity.getDeadline();
        }
        this.startDate = start;
        this.endDate = end;
    }

    public List<ActivityMockModel> addPseudoActivities() {
        // Must be sorted, TODO: implement sorting after startdate
        LocalDateTime[] start = new LocalDateTime[]{
                LocalDateTime.of(2021,11,1,0,0),
                LocalDateTime.of(2021,11,10,0,0),
                LocalDateTime.of(2021,11,18,0,0)
        };
        LocalDateTime[] end = new LocalDateTime[]{
                LocalDateTime.of(2021,11,20,0,0),
                LocalDateTime.of(2021,11,21,0,0),
                LocalDateTime.of(2021,12,10,0,0)
        };
        for (int i = 0; i<3; i++) {
            activities.add(new ActivityMockModel("Activity "+ (i+1), start[i], end[i]));
        }
        return activities;
    }
}

class ActivityMockModel {

    private String name;
    private LocalDateTime plannedStartDate;
    private LocalDateTime deadline;

    public ActivityMockModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        this.name = name;
        this.plannedStartDate = plannedStartDate;
        this.deadline = deadline;
    }

    public LocalDateTime getPlannedStartDate() {
        return plannedStartDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long calcSpanHours() {
        return plannedStartDate.until( deadline, ChronoUnit.HOURS );
    }

    public long calcOffsetHours() {
        long offset = (plannedStartDate.getDayOfMonth()-1)*24 + plannedStartDate.getHour();
        if (offset == 0) offset = 1;
        return offset;
    }

}