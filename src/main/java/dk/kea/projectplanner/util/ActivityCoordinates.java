package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.ActivityModel;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class ActivityCoordinates {

    private GanttUtility gu;

    public ActivityCoordinates(GanttUtility gu) {
        this.gu = gu;
    }

    public int startPage(ActivityModel activity){
        ZoomLevel cz = gu.currentZoomLevel;
        long page = gu.startColumn.until(activity.getPlannedStartDate(), cz.getChronoUnit());
        // System.out.println("StartPage for "+activity.getName()+ " : " + page);
        return (int) page;
    }

    public int endPage(ActivityModel activity){
        long page;
        // hours to start of activity
        long res = gu.startColumn.until(activity.getPlannedStartDate(), ChronoUnit.HOURS);
        ChronoUnit chronoUnit = gu.currentZoomLevel.getChronoUnit();

        if (gu.currentZoomLevel.getName().equals("month")) {
            // page span of activity
            page = activity.getPlannedStartDate().minusHours(res).toLocalDate().until(
                    activity.getDeadline().toLocalDate().with(
                            TemporalAdjusters.lastDayOfMonth()), chronoUnit);
        } else if (gu.currentZoomLevel.getName().equals("week")) {
            page = activity.getPlannedStartDate().minusHours(res).toLocalDate().until(
                    activity.getDeadline().toLocalDate().atStartOfDay().plusDays(1), chronoUnit);
        } else {
            page = activity.getPlannedStartDate().minusHours(res).until(activity.getDeadline(),
                    chronoUnit);
        }
        System.out.println("EndPage for "+activity.getName()+ " : " + page + " "+res+" "
                +activity.getPlannedStartDate().toString()+" "+activity.getDeadline().toString());
        return (int) page;
    }
    // for month/week
    private long calcColumnsSeen(int page) {
        long plusHours = 0;
        for (int i = 0; i < page; i++) {
            plusHours += gu.currentZoomLevel.calcColumnsPerPage(i, gu.startColumn);
        }
        // plusHours = gu.startColumn.until(gu.startColumn.plusMonths(gu.pagination.currentPage), ChronoUnit.HOURS);
        return plusHours;
    }

    public int calcColumnSpan(ActivityModel activity) {
        int currentPage = gu.pagination.currentPage;
        int pageOffset = startPage(activity);
        long hoursOffset = calcColumnOffset(activity, pageOffset);
        long plusHours = 0;
        if (gu.currentZoomLevel.getName().equals("day")){
            plusHours = (currentPage - pageOffset)* gu.columnsInPage.size()-hoursOffset;
        } else {
            plusHours = calcColumnsSeen(currentPage) - hoursOffset;
        }
        long hours = activity.getPlannedStartDate().plusHours(plusHours).until( activity.getDeadline(), ChronoUnit.HOURS );
        if (hours > gu.columnsInPage.size()) hours = gu.columnsInPage.size();
        System.out.println("spanning hours for "+activity.getName()+ " : " + (hours - calcColumnOffset(activity, currentPage)) + " " + plusHours);
        // if (currentPage == 0) return (int) hours - hoursOffset;
        return (int) (hours - calcColumnOffset(activity, currentPage));
    }

    public long calcColumnOffset(ActivityModel activity, int page) {
        long plusHours;
        if (gu.currentZoomLevel.getName().equals("month")) {
            plusHours = calcColumnsSeen(page);
        } else {
            plusHours = page * gu.columnsInPage.size();
        }
        long offset = gu.startColumn.plusHours(plusHours).until(activity.getPlannedStartDate(), ChronoUnit.HOURS);
        if (offset < 0) offset = 0;
        return offset; // off by one
    }

}
