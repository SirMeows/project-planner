package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.Activity;
import dk.kea.projectplanner.models.ProjectModel;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;

public class GanttUtility {

    public ZoomLevel zoomLevel;
    public EnumMap<ZoomLevel, Double> zoomLevelColSizeMap = new EnumMap<>(ZoomLevel.class);
    public double colSize;
    public LocalDateTime startDate, endDate;
    public String[] activityColors = new String[]{"#b03532", "#33a8a5","#30997a","#6a478f","#da6f2b","#3d8bb1","#e03f3f","#59a627","#4464a1"};
    public List<Activity> activities = new ArrayList<>();
    public List<LocalDateTime> hoursTotal = new ArrayList<>();
    public TextStyle txtStyle = TextStyle.FULL;
    public Locale locale = Locale.getDefault();
    public WeekFields weekFields = WeekFields.of(locale);

    public GanttUtility() {
        zoomLevelColSizeMap.put(ZoomLevel.DAY, 54.0);
        zoomLevelColSizeMap.put(ZoomLevel.WEEK, 7.8);
        zoomLevelColSizeMap.put(ZoomLevel.MONTH, 1.82);
        addPseudoActivities();
        calcStartAndEndDate();
        populateDays();
    }

    public void populateDays() {
        for (LocalDateTime date = startDate; date.isBefore(endDate); date = date.plusHours(1))
        {
            this.hoursTotal.add(date);
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
        long offset = startDate.until(activity.getPlannedStartDate(), ChronoUnit.HOURS);
        // if (offset == 0) offset = 1; // TODO: Turn back here
        return offset + 1;
    }

    public int calcWeekOffsetHours() {
        return startDate.getDayOfWeek().getValue()*24 + startDate.getHour() -24;
    }

    public int calcMonthOffsetHours() {
        return startDate.getDayOfMonth()*24 + startDate.getHour() -24;
    }

    public int hoursInMonth(LocalDateTime dateTime) {
        return (dateTime.plusHours(1).toLocalDate().lengthOfMonth()*24);
    }

    public void addPseudoActivities() {
        // TODO: implement sorting after startdate
        LocalDateTime[] start = new LocalDateTime[]{
                LocalDateTime.of(2021,12,2,0,0),
                LocalDateTime.of(2021,12,10,0,0),
                LocalDateTime.of(2021,12,18,0,0)
        };
        LocalDateTime[] end = new LocalDateTime[]{
                LocalDateTime.of(2021,12,10,0,0),
                LocalDateTime.of(2021,12,21,0,0),
                LocalDateTime.of(2022,1,10,0,0)
        };
        for (int i = 0; i<3; i++) {
            activities.add(new ProjectModel("Activity "+ (i+1), start[i], end[i]));
        }
    }
}