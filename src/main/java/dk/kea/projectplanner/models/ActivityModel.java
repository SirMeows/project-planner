package dk.kea.projectplanner.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ActivityModel {
    private long id;
    private String name;
    private String level;
    private long dateTimeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime plannedStartDate;
    private LocalDateTime actualStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime deadline;
    private LocalDateTime actualEndDate;
    private long parentId;
    private int levelId; // decides type of activity and location in hierarchy
    private int taskSize; // total task size estimate in hours

    public ActivityModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline, int taskSize) {
        this.name = name;
        this.plannedStartDate = plannedStartDate;
        this.deadline = deadline;
        this.taskSize = taskSize;
    }

    public ActivityModel() {
    }

    public ActivityModel(int level) {
        levelId = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getId() {
        return id;
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

    public int getTaskSize() {
        return taskSize;
    }

    public void setTaskSize(int taskSize) {
        this.taskSize = taskSize;
    }

}

//TODO: If there is time, add Discipline to ActivityImpl and Person in order to find qualified personnel for activities
