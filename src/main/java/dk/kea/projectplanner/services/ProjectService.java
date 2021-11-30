package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepos;

    public ProjectService(ProjectRepository projectRepos) {
        this.projectRepos = projectRepos;
    }

    void createProject(ProjectModel projectModel) {
        projectRepos.createDateTime(projectModel);
        projectRepos.createActivity(projectModel);
        projectRepos.createProject(projectModel);
    }
}
