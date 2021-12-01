package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectModel extends Activity {
    private List<SubProjectModel> subProjects;

    public ProjectModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }

    public List<SubProjectModel> getSubProjects() {
        return subProjects;
    }
}
