package dk.kea.projectplanner.models;

import java.time.LocalDateTime;

public abstract class ActivityImpl {
    private long id;
    private String name;
    private LocalDateTime plannedStartDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime deadline;
    private LocalDateTime actualEndDate;
    //TODO: Add Discipline to ActivityImpl and Person in order to find qualified personnel for activities
}
