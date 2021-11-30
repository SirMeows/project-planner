package dk.kea.projectplanner.models;

import java.util.List;

public class ProjectModel extends Activity {
    private List<SubProjectModel> subProjects;

    public List<SubProjectModel> getSubProjects() {
        return subProjects;
    }
}
