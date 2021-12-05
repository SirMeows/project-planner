package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.SubTaskModel;
import dk.kea.projectplanner.repositories.ActivityRepository;
import dk.kea.projectplanner.repositories.SubTaskRepository;
import dk.kea.projectplanner.util.ListToMapUtility;

import java.util.Map;

public class SubTaskService extends ActivityService<SubTaskModel> {

    private final SubTaskRepository subTaskRepos;

    public SubTaskService(SubTaskRepository subTaskRepos) {
        this.subTaskRepos = subTaskRepos;
    }

    @Override
    ActivityRepository<SubTaskModel> getRepository() {
        return subTaskRepos;
    }

    SubTaskModel createSubTask(SubTaskModel subTaskModel) {
        createActivity(subTaskModel);
        subTaskRepos.createSubTask(subTaskModel);
        return subTaskModel;
    }

    Map<Long,SubTaskModel> findAllSubTasks() {
        return ListToMapUtility.listToMap(subTaskRepos.findAllSubTasks());
    }
}
