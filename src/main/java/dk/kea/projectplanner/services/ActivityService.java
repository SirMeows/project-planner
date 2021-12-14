package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.ActivityModel;
import dk.kea.projectplanner.repositories.ActivityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    ActivityRepository repos;

    public ActivityService(ActivityRepository repos) {
        this.repos = repos;
    }

    public List<ActivityModel> findAll() {
        return repos.findAll();
    }


    public List<ActivityModel> findAllByLevel(String name) {
        return repos.findAll().stream().filter(
                p -> p.getLevel().equals(name)).collect(Collectors.toList());
    }

    public ActivityModel findById(long id) {
        return repos.findById(id);
    }
    // returns subactivities for the provided id
    public List<ActivityModel> findByParentId(long id) {
        return repos.findSubActivitiesByParentId(id);
    }

    public String levelNameByLevelId(int id) {
        return repos.findLevelById(id);
    }

    public List<ActivityModel> findAllByLevelId(int id) {
        return repos.findAll().stream().filter(p -> p.getLevelId() == id).collect(Collectors.toList());
    }

    void updateDateTime(ActivityModel activity) {
        repos.updateActualEndDate(activity);
        repos.updateDeadline(activity);
        repos.updateActualStartDate(activity);
        repos.updatePlannedStartDate(activity);
    }

    public void createActivity(ActivityModel activity) {
        repos.createDateTime(activity);
        repos.createActivity(activity);
        // Project has no parent activity
        if ( !activity.getLevel().equals("Project") )
            addSubActivity(activity.getParentId(), activity);
    }

    public void addSubActivity(long activityId, ActivityModel subActivity) {
        repos.addSubActivity(activityId, subActivity);
    }

    public int levelIdByName(String level) {
        return repos.findLevelIdByName(level);
    }

    public int deleteActivity(long id) {
        return repos.deleteActivity(id);
    }
    // delete activity and subactivities recursively
    public int deleteActivityAndSubActivities(long id) {
        List<ActivityModel> subActivities = findByParentId(id);
        if (!subActivities.isEmpty()) {
            for (ActivityModel activity : subActivities) {
                deleteActivityAndSubActivities(activity.getId());
            }
        }
        return deleteActivity(id);
    }
}
