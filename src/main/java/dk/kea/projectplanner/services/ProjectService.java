package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.models.SubProjectModel;
import dk.kea.projectplanner.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepo;

    public ProjectService(ProjectRepository projectRepos) {
        this.projectRepo = projectRepos;
    }

    @Transactional // Only executes this method if all parts succeed
    ProjectModel createProject(ProjectModel projectModel) {
        projectRepo.createDateTime(projectModel);
        projectRepo.createActivity(projectModel);
        projectRepo.createProject(projectModel);
        return projectModel; // Could query from db
    }

    ProjectModel findProjectById(long id) {
        return projectRepo.findById(id);
    }

    @Transactional
    ProjectModel addSubProjectToProject(ProjectModel projectModel, SubProjectModel subProjectModel) {
        projectRepo.addSubProjectToProject(projectModel, subProjectModel);
        projectModel.addSubProject(subProjectModel);
        return projectModel;
    }

    ProjectModel populateSubprojects(long id) {
        var projectModel = findProjectById(id);
        projectModel.populateSubprojects(listToMap(projectRepo.findSubProjectsByProjectId(id)));
        return projectModel;
    }

    private Map<Long, SubProjectModel> listToMap(List<SubProjectModel> subProjectModelList) {
        return subProjectModelList.stream().collect(Collectors.toMap(SubProjectModel::getId, Function.identity()));
    }

    @Transactional
    void updateDateTime(ProjectModel projectModel) {
        projectRepo.updateActualEndDate(projectModel);
        projectRepo.updateDeadline(projectModel);
        projectRepo.updateActualStartDate(projectModel);
        projectRepo.updatePlannedStartDate(projectModel);
    }
}
