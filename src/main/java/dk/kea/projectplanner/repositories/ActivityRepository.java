package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.ActivityModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Transactional// Only executes a method if all parts succeed
public interface ActivityRepository <T extends ActivityModel> {

    @Update("UPDATE date_time SET planned_start_date = #{plannedStartDate} WHERE date_time_id = #{dateTimeId}")
    int updatePlannedStartDate(T activity);

    @Update("UPDATE date_time SET actual_start_date = #{actualStartDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualStartDate(T activity);

    @Update("UPDATE date_time SET deadline = #{deadline} WHERE date_time_id = #{dateTimeId}")
    int updateDeadline(T activity);

    @Update("UPDATE date_time SET actual_end_date = #{actualEndDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualEndDate(T activity);

    @Insert("INSERT INTO date_time (date_time_id, planned_start_date, actual_start_date, deadline, actual_end_date)" +
            "VALUES (#{dateTimeId}, #{plannedStartDate}, #{actualStartDate}, #{deadline}, #{actualEndDate})")
    @Options(useGeneratedKeys = true, keyColumn = "date_time_id", keyProperty = "dateTimeId")
    void createDateTime(T activity);

    @Insert("INSERT INTO activity (activity_id, name, date_time_id) VALUES (#{activityId}, #{name}, #{dateTimeId});")
    @Options(useGeneratedKeys = true, keyColumn = "activity_id", keyProperty = "activityId")
    void createActivity(T activity);
}
