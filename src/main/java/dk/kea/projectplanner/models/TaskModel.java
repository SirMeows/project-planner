package dk.kea.projectplanner.models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskModel extends Activity {
    private Map<Long,SubTaskModel> subTasks = new HashMap<>();

    public TaskModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }

    public TaskModel() {
    }

    public void addSubTask(SubTaskModel subTaskModel) {
        subTasks.put(subTaskModel.getId(),subTaskModel);
    }

    public void populateSubTasks(Map<Long,SubTaskModel> subTasks) {
        subTasks = subTasks;
    }

    public boolean containsSubTask(SubTaskModel subTaskModel) {
        return subTasks.containsKey(subTaskModel.getId());
    }
}
