package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.Activity;
import dk.kea.projectplanner.repositories.ActivityRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class ActivityService <P extends Activity> {

    abstract ActivityRepository<P> getRepository();

    void updateDateTime(P activity) {
        getRepository().updateActualEndDate(activity);
        getRepository().updateDeadline(activity);
        getRepository().updateActualStartDate(activity);
        getRepository().updatePlannedStartDate(activity);
    }

    protected void createActivity(P activity) {
        getRepository().createDateTime(activity);
        getRepository().createActivity(activity);
    }
}
