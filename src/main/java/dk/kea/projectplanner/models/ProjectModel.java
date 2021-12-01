package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProjectModel extends Activity {
    // Initializing list here works to avoid NullPointer exceptions but causes an issue when trying to determine
    // whether there was a problem with the db query or there are no models on this list yet
    private List<SubProjectModel> subProjects = new ArrayList<>();

    public ProjectModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }

    public ProjectModel() {
    }

    public List<SubProjectModel> getSubProjects() {
        return subProjects;
    }
}
