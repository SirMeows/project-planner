package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.ActivityModel;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ManhourCalculator {

    public static int calculateManhoursForSingleActivity(ActivityModel activity) {
        double taskSize = activity.getTaskSize(); // hours
        int workDays = calculateNrOfWorkDaysFromDates(activity);
        return (int) Math.ceil(taskSize / workDays);
    }

    private static int calculateNrOfWorkDaysFromDates(ActivityModel activity) {
        var workDayCount = 0;
        var start = activity.getPlannedStartDate();
        var end = activity.getDeadline();

        for (LocalDateTime date = start; date.isBefore(end); date = date.plusDays(1))
            if(date.getDayOfWeek() != DayOfWeek.SUNDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY) {
                workDayCount += 1;
            }
        return workDayCount;
    }
}
