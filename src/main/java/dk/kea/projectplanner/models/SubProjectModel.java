package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.List;

public class SubProjectModel extends Activity {
    private List<TaskModel> taskModels;

    public SubProjectModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }
}
