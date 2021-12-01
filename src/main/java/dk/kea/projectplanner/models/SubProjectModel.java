package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SubProjectModel extends Activity {
    private List<TaskModel> taskModels = new ArrayList<>();

    public SubProjectModel() {
    }

    public SubProjectModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }

    public List<TaskModel> getSubProjects() {
        return taskModels;
    }
}
