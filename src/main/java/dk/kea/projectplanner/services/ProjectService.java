package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.models.SubProjectModel;
import dk.kea.projectplanner.repositories.ActivityRepository;
import dk.kea.projectplanner.repositories.ProjectRepository;
import dk.kea.projectplanner.util.ListToMapUtility;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProjectService extends ActivityService<ProjectModel> {

    private final ProjectRepository projectRepos;

    public ProjectService(ProjectRepository projectRepos) {
        this.projectRepos = projectRepos;
    }

    @Override
    ActivityRepository<ProjectModel> getRepository() {
        return projectRepos;
    }

    public ProjectModel createProject(ProjectModel projectModel) {
        createActivity(projectModel);
        projectRepos.createProject(projectModel);
        //System.out.println(projectModel.getPlannedStartDate().toString());
        return projectModel;
    }

    ProjectModel findProjectById(long id) {
        return projectRepos.findById(id);
    }

    public Map<Long,ProjectModel> findAllProjects() {
        return ListToMapUtility.listToMapActivity(projectRepos.findAllProjects());
    }
        void deleteById(long id) {
        projectRepos.deleteById(id);
    }

    ProjectModel addSubProjectToProject(ProjectModel projectModel, SubProjectModel subProjectModel) {
        projectRepos.addSubProjectToProject(projectModel, subProjectModel);
        projectModel.addSubProject(subProjectModel);
        return projectModel;
    }

    ProjectModel populateSubprojects(long id) {
        var projectModel = findProjectById(id);
        projectModel.populateSubprojects(ListToMapUtility.listToMapActivity(projectRepos.findSubProjectsByProjectId(id)));
        return projectModel;
    }
}
