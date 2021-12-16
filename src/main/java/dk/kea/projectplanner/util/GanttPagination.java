/*
Author Peter
10.12.2021
 */
package dk.kea.projectplanner.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GanttPagination {

    public int currentPage;

    public boolean endPage(ZoomLevel currentZoomLevel, LocalDateTime startDate, LocalDateTime endDate) {
        int span = currentPage+1; // Time span shown until now
        if (currentZoomLevel.getName().equals("day")) {
            return span >= startDate.until(endDate, ChronoUnit.DAYS);
        } else if (currentZoomLevel.getName().equals("week")){
            return span >= startDate.until(endDate, ChronoUnit.WEEKS);
        } else {
            return span >= startDate.until(endDate, ChronoUnit.MONTHS);
        }
    }

}
