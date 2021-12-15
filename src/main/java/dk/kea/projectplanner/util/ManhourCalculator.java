package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.ActivityModel;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ManhourCalculator {

    public int calculateManhoursForSingleActivity(ActivityModel activity) {
        double taskSize = activity.getTaskSize(); // hours
        int workDays = calculateNrOfWorkDaysFromDates(activity);
        return (int) Math.ceil(taskSize / workDays);
    }

    private int calculateNrOfWorkDaysFromDates(ActivityModel activity) {
        var workDayCount = 0;
        var start = activity.getActualStartDate();
        var end = activity.getDeadline();

        for (LocalDateTime date = start; date.isBefore(end); date = date.plusDays(1))
            if(date.getDayOfWeek() != DayOfWeek.SUNDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY) {
                workDayCount += 1;
            }
        return workDayCount;
    }
}
