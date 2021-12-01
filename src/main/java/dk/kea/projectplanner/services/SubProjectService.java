package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.SubProjectModel;
import dk.kea.projectplanner.repositories.SubProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubProjectService {
    private final SubProjectRepository subProjectRepos;

    public SubProjectService(SubProjectRepository subProjectRepos) {
        this.subProjectRepos = subProjectRepos;
    }

    @Transactional
    SubProjectModel createSubProject(SubProjectModel subProjectModel) {
        subProjectRepos.createDateTime(subProjectModel);
        subProjectRepos.createActivity(subProjectModel);
        subProjectRepos.createSubProject(subProjectModel);
        return subProjectModel;

    }
}
