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
    void createProject(ProjectModel projectModel) {
        projectRepos.createDateTime(projectModel);
        projectRepos.createActivity(projectModel);
        projectRepos.createProject(projectModel);
    }

    @Transactional
    void addSubProjectToCollection(ProjectModel projectModel, SubProjectModel subProjectModel) {
        
    }
}
