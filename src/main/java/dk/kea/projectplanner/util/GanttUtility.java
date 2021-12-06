package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.ActivityModel;
import dk.kea.projectplanner.models.ProjectModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class GanttUtility {

    public List<ZoomLevel> zoomLevels = new ArrayList<>();
    public ZoomLevel currentZoomLevel;
    public int currentPage;
    public LocalDateTime startDate, endDate;
    public String[] activityColors = new String[]{"#b03532", "#33a8a5","#30997a","#6a478f","#da6f2b","#3d8bb1","#e03f3f","#59a627","#4464a1"};
    public List<LocalDateTime> hours = new ArrayList<>();
    public List<LocalDateTime> hoursPage = new ArrayList<>();
    public List<ActivityModel> activities = new ArrayList<>();
    public List<LocalDateTime> days = new ArrayList<>();

    public GanttUtility() {
        zoomLevels.add(new ZoomLevel("day", 54.0, "EEEE dd-MM-uuuu","HH",24,1));
        zoomLevels.add(new ZoomLevel("week", 7.8, "'Week' w - uuuu","EEEE",168,24));
        zoomLevels.add(new ZoomLevel("month", 1.82, "MMMM uuuu","dd",0,24));
        //currentZoomLevel = zoomLevels.get(0);
        addPseudoActivities();
        //calcStartAndEndDate();
    }

    public void updateHours() {
        this.hours.clear();
        for (LocalDateTime date = startDate; date.isBefore(endDate); date = date.plusHours(1)) {
            this.hours.add(date);
        }
    }

    public boolean endPage() {
        if (currentZoomLevel.getName().equals("day")) {
            return currentPage == startDate.until(endDate, ChronoUnit.DAYS);
        } else if (currentZoomLevel.getName().equals("week")){
            return currentPage == startDate.until(endDate, ChronoUnit.WEEKS);
        } else {
            return currentPage == startDate.until(endDate, ChronoUnit.MONTHS);
        }
    }

    public void calcStartAndEndDate() {
        LocalDateTime start = activities.get(0).getPlannedStartDate();
        LocalDateTime end = start;
        for (ActivityModel activityModel : activities) {
            if (activityModel.getPlannedStartDate().isBefore(start)) start = activityModel.getPlannedStartDate();
            if (activityModel.getDeadline().isAfter(end)) end = activityModel.getDeadline();
        }
        switch(this.currentZoomLevel.getName()) {
            case "day":
                start = start.toLocalDate().atStartOfDay();
                end = end.plusDays(1).toLocalDate().atStartOfDay();
                break;
            case "week":
                start = start.toLocalDate().atStartOfDay().minusDays(start.getDayOfWeek().getValue()-1);
                end = end.toLocalDate().atStartOfDay().plusDays((7 - end.getDayOfWeek().getValue())).plusDays(1); //plusHours(23);
                break;
            case "month":
                start = start.toLocalDate().with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay();
                end = end.toLocalDate().with(TemporalAdjusters.lastDayOfMonth()).atTime(23,0);
                System.out.println("startM: " +start);
                System.out.println("EndM: "+end);
                break;
            default:
        }
        this.startDate = start;
        this.endDate = end;
    }

    public List<LocalDateTime> getHoursToShow() {
        int startIndex = 0, endIndex;
        int hpp = currentZoomLevel.calcHoursPerPage(currentPage, startDate);
        if (currentZoomLevel.getName().equals("month")) {
            for(int i = 0; i < currentPage; i++) {
                startIndex += currentZoomLevel.calcHoursPerPage(i, startDate);
            }
            endIndex = startIndex + hpp;
        } else {
            startIndex = currentPage*hpp;
            endIndex =  (currentPage+1)*hpp;
        }
        if (! (endIndex < hours.size()) ) endIndex = hours.size() -1; //
        if (! (startIndex < hours.size()) ) startIndex = hours.size() -1;
        return hours.subList(startIndex, endIndex);
    }

    public int startPage(ActivityModel activity){
        long res = -1;
        int hpp = hoursPage.size();
        //if (hpp == 0) hpp++;
        if (currentZoomLevel.getName() == "month") {
            res = this.startDate.until(activity.getPlannedStartDate(), ChronoUnit.MONTHS);
        } else {
            res = this.startDate.until(activity.getPlannedStartDate(), ChronoUnit.HOURS) / hoursPage.size();
        }
        System.out.println("StartPage for "+activity.getName()+ " : " + res);
        return (int) res;
    }

    public int endPage(ActivityModel activity){
        int pageOffset = startPage(activity);
        int hoursOffset = calcOffsetHours(activity, pageOffset) -1;
        // int hoursToStart = pageOffset*hours.size() + hoursOffset;
        long total = activity.getPlannedStartDate().minusHours(
                (startPage(activity))*hoursPage.size()-hoursOffset)
                .until(activity.getDeadline(), ChronoUnit.HOURS);
        long page = -1;
        if (currentZoomLevel.getName().equals("month")) {
            int res = 0;
            for (LocalDate date = startDate.toLocalDate(); date.isBefore(activity.getPlannedStartDate().toLocalDate()); date = date.plusDays(1)) {
                res += 24;
            }
            page = activity.getPlannedStartDate().minusHours(res).toLocalDate().until(
                    activity.getDeadline().toLocalDate().with(TemporalAdjusters.lastDayOfMonth()), ChronoUnit.MONTHS);
        } else if (currentZoomLevel.getName().equals("week")) {
            int res = 0;
            for (LocalDate date = startDate.toLocalDate(); date.isBefore(activity.getPlannedStartDate().toLocalDate()); date = date.plusDays(1)) {
                res += 24;
            }
            page = activity.getPlannedStartDate().minusHours(res).toLocalDate().until(
                    activity.getDeadline().toLocalDate().atStartOfDay().plusDays(1), ChronoUnit.WEEKS);
        } else {
            page = total/hoursPage.size();
        }
        System.out.println("EndPage for "+activity.getName()+ " : " + page);
        return (int) page;
    }
    // for month
    public int calcPlusHours(int page) {
        int plusHours = 0;
        if (currentZoomLevel.getName().equals("month")) {
            for (int i = 0; i < page; i++) {
                plusHours += currentZoomLevel.calcHoursPerPage(i, startDate);
            }
        } else {

        }
        return plusHours;
    }

    public int calcSpanHours(ActivityModel activity) {
        int pageOffset = startPage(activity);
        int hoursOffset = calcOffsetHours(activity, pageOffset)-1;
        int plusHours = 0;
        if (currentZoomLevel.getName().equals("month")) {
            plusHours = calcPlusHours(currentPage)-hoursOffset;
        } else if (currentZoomLevel.getName().equals("week")){
            plusHours = (currentPage - pageOffset)*hoursPage.size()-hoursOffset;
            // if last page
            if (currentPage == (hours.size()/hoursPage.size())-1) plusHours += currentPage;
        } else {
            plusHours = (currentPage - pageOffset)*hoursPage.size()-hoursOffset;
            // if last page
            if (currentPage == (hours.size()/hoursPage.size())-1) plusHours += currentPage;
        }

        long hours = activity.getPlannedStartDate().plusHours(plusHours).until( activity.getDeadline(), ChronoUnit.HOURS );
        if (hours > hoursPage.size()) hours = hoursPage.size();
        // System.out.println("spanning dAYS for "+activity.getName()+ " : " + (hours+hoursOffset)/24 + " " + plusHours);

        if (currentPage == 0) return (int) hours - hoursOffset;
        return (int) (hours);
    }

    public int calcOffsetHours(ActivityModel activity, int page) {
        int plusHours;
        if (currentZoomLevel.getName().equals("month")) {
            plusHours = calcPlusHours(page);
        } else {
            plusHours = page*hoursPage.size();
        }
        long offset = startDate.plusHours(plusHours).until(activity.getPlannedStartDate(), ChronoUnit.HOURS);
        if (offset < 0) offset = 0;
        return (int) offset + 1; // off by one
    }

    public int hoursInMonth(LocalDateTime dateTime) {
        return dateTime.toLocalDate().lengthOfMonth()*24;
    }

    public void addPseudoActivities() {
        // TODO: implement sorting after startdate
        LocalDateTime[] start = new LocalDateTime[]{
                LocalDateTime.of(2021,12,1,0,0),
                LocalDateTime.of(2021,12,2,0,0),
                LocalDateTime.of(2021,12,3,0,0)
        };
        LocalDateTime[] end = new LocalDateTime[]{
                LocalDateTime.of(2021,12,4,0,0),
                LocalDateTime.of(2021,12,5,0,0),
                LocalDateTime.of(2022,2,6,0,0)
        };
        for (int i = 0; i<3; i++) {
            activities.add(new ProjectModel("Activity "+ (i+1), start[i], end[i]));
        }
    }
}