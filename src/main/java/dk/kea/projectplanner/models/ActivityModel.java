package dk.kea.projectplanner.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class ActivityModel {
    private long id;
    private long activityId;
    private String name;
    private long dateTimeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime plannedStartDate;
    private LocalDateTime actualStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime deadline;
    private LocalDateTime actualEndDate;

    public ActivityModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        this.name = name;
        this.plannedStartDate = plannedStartDate;
        this.deadline = deadline;
    }

    public ActivityModel() {
    }

    public long getId() {
        return id;
    }

    public long getActivityId() {
        return activityId;
    }

    public String getName() {
        return name;
    }

    public long getDateTimeId() {
        return dateTimeId;
    }

    public LocalDateTime getPlannedStartDate() {
        return plannedStartDate;
    }

    public LocalDateTime getActualStartDate() {
        return actualStartDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public LocalDateTime getActualEndDate() {
        return actualEndDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateTimeId(long dateTimeId) {
        this.dateTimeId = dateTimeId;
    }

    public void setPlannedStartDate(LocalDateTime plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public void setActualStartDate(LocalDateTime actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setActualEndDate(LocalDateTime actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityModel activityModel = (ActivityModel) o;
        return id == activityModel.id && activityId == activityModel.activityId && dateTimeId == activityModel.dateTimeId && Objects.equals(name, activityModel.name) && Objects.equals(plannedStartDate, activityModel.plannedStartDate) && Objects.equals(actualStartDate, activityModel.actualStartDate) && Objects.equals(deadline, activityModel.deadline) && Objects.equals(actualEndDate, activityModel.actualEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activityId, name, dateTimeId, plannedStartDate, actualStartDate, deadline, actualEndDate);
    }
}

//TODO: If there is time, add Discipline to ActivityImpl and Person in order to find qualified personnel for activities
