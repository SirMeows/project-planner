package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.Activity;
import dk.kea.projectplanner.models.ProjectModel;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GanttUtility {

    public String zoomLevel;
    public int colSize;
    public LocalDateTime startDate, endDate;
    public String[] activityColors = new String[]{"#b03532", "#33a8a5","#30997a","#6a478f","#da6f2b","#3d8bb1","#e03f3f","#59a627","#4464a1"};
    public List<Activity> activities = new ArrayList<>();
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
        for (Activity activity : activities) {
            if (activity.getPlannedStartDate().isBefore(start)) start = activity.getPlannedStartDate();
            if (activity.getDeadline().isAfter(end)) end = activity.getDeadline();
        }
        this.startDate = start;
        this.endDate = end;
    }

    public long calcSpanHours(Activity activity) {
        return activity.getPlannedStartDate().until( activity.getDeadline(), ChronoUnit.HOURS );
    }

    public long calcOffsetHours(Activity activity) {
        long offset = (activity.getPlannedStartDate().getDayOfMonth()-1)*24 + activity.getPlannedStartDate().getHour();
        if (offset == 0) offset = 1;
        return offset;
    }

    public void addPseudoActivities() {
        // TODO: implement sorting after startdate
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
            activities.add(new ProjectModel("Activity "+ (i+1), start[i], end[i]));
        }
    }
}