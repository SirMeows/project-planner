package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SubProjectModel extends Activity {
    private Map<Long,TaskModel> tasks = new HashMap<>();

    public SubProjectModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }

    public SubProjectModel() {
    }

    public void addTask(TaskModel taskModel) {
        tasks.put(taskModel.getId(), taskModel);
    }

    public void populateTasks(Map<Long,TaskModel> taskModelMap) {
        tasks = taskModelMap;
    }
}
