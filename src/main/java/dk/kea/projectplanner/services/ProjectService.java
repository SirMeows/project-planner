package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.models.SubProjectModel;
import dk.kea.projectplanner.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepos;

    public ProjectService(ProjectRepository projectRepos) {
        this.projectRepos = projectRepos;
    }

    @Transactional // Only executes this method if all parts succeed
    ProjectModel createProject(ProjectModel projectModel) {
        projectRepos.createDateTime(projectModel);
        projectRepos.createActivity(projectModel);
        projectRepos.createProject(projectModel);
        return projectModel; // Could query from db
    }

    @Transactional
    ProjectModel addSubProjectToProject(ProjectModel projectModel, SubProjectModel subProjectModel) {
        projectRepos.addSubProjectToProject(projectModel, subProjectModel);
        projectModel.addSubProject(subProjectModel);
        return projectModel;
    }

    //TODO: Can this be pulled to a superclass to be used by all activities?
    @Transactional
    void updateDateTime(ProjectModel projectModel) {
        projectRepos.updateActualEndDate(projectModel);
        projectRepos.updateDeadline(projectModel);
        projectRepos.updateActualStartDate(projectModel);
        projectRepos.updatePlannedStartDate(projectModel);
    }
}
