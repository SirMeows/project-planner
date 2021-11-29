package dk.kea.projectplanner.models;

import java.time.LocalDateTime;

public abstract class Activity {
    private long id;
    private long activityId;
    private String name;
    private long dateTimeId;
    private LocalDateTime plannedStartDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime deadline;
    private LocalDateTime actualEndDate;
    //TODO: Add Discipline to ActivityImpl and Person in order to find qualified personnel for activities
}
