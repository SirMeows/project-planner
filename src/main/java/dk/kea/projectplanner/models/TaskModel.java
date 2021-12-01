package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.List;

public class TaskModel extends Activity {
    private List<SubTaskModel> subTaskModels;

    public TaskModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }
}
