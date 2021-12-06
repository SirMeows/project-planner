package dk.kea.projectplanner.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ZoomLevel {

    private String name;
    private double colSize;
    // Headings for gantt chart depends on Zoom
    private DateTimeFormatter h1, h2;
    private int h1Span, h2Span;

    private int hourOffset; // offset in hours from beginning of day/week/month
    private int columnCount;

    public ZoomLevel(String name, double colSize, String h1Format, String h2Format, int h1Span, int h2Span) {
        this.name = name;
        this.colSize = colSize;
        this.h1 = DateTimeFormatter.ofPattern(h1Format);
        this.h2 = DateTimeFormatter.ofPattern(h2Format);
        this.h1Span = h1Span;
        this.h2Span = h2Span;
    }

    public int calcHoursPerPage(int page, LocalDateTime startDate){
        switch(this.name) {
            case "day":
                return 24;
            case "week":
                return 168;
            case "month":
                LocalDateTime currentMonth = startDate.plusMonths(page);
                System.out.println("length of current month: "+currentMonth.toLocalDate().lengthOfMonth());
                return currentMonth.toLocalDate().lengthOfMonth()*24;
            default:
        }
        return -1;
    }

    public boolean evalCondition(LocalDateTime hour){
        switch(this.name) {
            case "day":
                return hour.getHour() == 0;
            case "week":
                return hour.getDayOfWeek().getValue() == 1 && hour.getHour() == 0;
            case "month":
                return hour.getDayOfMonth() == 1;
            default:
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getColSize() {
        return colSize;
    }

    public void setColSize(double colSize) {
        this.colSize = colSize;
    }

    public DateTimeFormatter getH1() {
        return h1;
    }

    public DateTimeFormatter getH2() {
        return h2;
    }

    public int getH1Span() {
        return h1Span;
    }

    public int getH2Span() {
        return h2Span;
    }
}
