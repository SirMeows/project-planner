package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.*;

public class ProjectModel extends ActivityModel {
    // Initializing list here works to avoid NullPointer exceptions but causes an issue when trying to determine
    // whether there was a problem with the db query or there are no models on this list yet
    private Map<Long,SubProjectModel> subProjects = new HashMap<>();

    public ProjectModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }

    public ProjectModel() {
    }

    public void addSubProject(SubProjectModel subProjectModel) {
        subProjects.put(subProjectModel.getId(),subProjectModel);
    }

    public void populateSubprojects(Map<Long,SubProjectModel> subProjects) {
        subProjects = subProjects;
    }

    public boolean containsSubProject(SubProjectModel subProjectModel) {
        return subProjects.containsKey(subProjectModel.getId());
    }

}