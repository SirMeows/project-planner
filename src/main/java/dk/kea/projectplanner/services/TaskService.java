package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.SubTaskModel;
import dk.kea.projectplanner.models.TaskModel;
import dk.kea.projectplanner.repositories.ActivityRepository;
import dk.kea.projectplanner.repositories.TaskRepository;
import dk.kea.projectplanner.util.ListToMapUtility;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TaskService extends ActivityService<TaskModel>{

    private final TaskRepository taskRepos;

    public TaskService(TaskRepository taskRepos) {
        this.taskRepos = taskRepos;
    }

    @Override
    ActivityRepository<TaskModel> getRepository() {
        return taskRepos;
    }

    TaskModel createTask(TaskModel taskModel) {
        createActivity(taskModel);
        taskRepos.createTask(taskModel);
        return taskModel;
    }

    TaskModel findTaskById(long id) {
        return taskRepos.findById(id);
    }

    Map<Long,TaskModel> findAllTasks() {
        return ListToMapUtility.listToMap(taskRepos.findAllTasks());
    }

    TaskModel addSubTaskToTask(TaskModel taskModel, SubTaskModel subTaskModel) {
        taskRepos.addSubTaskToTask(taskModel, subTaskModel);
        taskModel.addSubTask(subTaskModel);
        return taskModel;
    }

    TaskModel populateSubTasks(long id) {
        var taskModel = findTaskById(id);
        taskModel.populateSubTasks(ListToMapUtility.listToMap(taskRepos.findSubTasksByTaskId(id)));
        return taskModel;
    }
}
