package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.SubProjectModel;
import dk.kea.projectplanner.models.TaskModel;
import dk.kea.projectplanner.repositories.ActivityRepository;
import dk.kea.projectplanner.repositories.SubProjectRepository;
import dk.kea.projectplanner.util.ListToMapUtility;
import org.springframework.stereotype.Service;

@Service
public class SubProjectService extends ActivityService<SubProjectModel>{
    private final SubProjectRepository subProjectRepos;

    public SubProjectService(SubProjectRepository subProjectRepos) {
        this.subProjectRepos = subProjectRepos;
    }

    @Override
    ActivityRepository<SubProjectModel> getRepository() {
        return subProjectRepos;
    }

    SubProjectModel createSubProject(SubProjectModel subProjectModel) {
        subProjectRepos.createDateTime(subProjectModel);
        subProjectRepos.createActivity(subProjectModel);
        subProjectRepos.createSubProject(subProjectModel);
        return subProjectModel;
    }

    SubProjectModel findSubProjectById(long id) {
        return subProjectRepos.findById(id);
    }

    SubProjectModel addTaskToSubProject(SubProjectModel subProjectModel, TaskModel taskModel) {
        subProjectRepos.addTaskToSubProject(subProjectModel, taskModel);
        subProjectModel.addTask(taskModel);
        return subProjectModel;
    }

    SubProjectModel populateTasks(long id) {
        var subProjectModel = findSubProjectById(id);
        subProjectModel.populateTasks(ListToMapUtility.listToMap(subProjectRepos.findTasksBySubProjectId(id)));
        return subProjectModel;
    }
}
