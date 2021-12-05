package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.SubProjectModel;
import dk.kea.projectplanner.models.TaskModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubProjectRepository extends ActivityRepository<SubProjectModel>{

    @Select("SELECT * FROM subproject_view")
    @Results(value = {
            @Result(property="id", column="subproject_id"),
            @Result(property="activityId", column="subproject_activity_id"),
            @Result(property="name", column="subproject_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    List<SubProjectModel> findAllSubProjects();

    @Select("SELECT * FROM subproject_view WHERE subproject_id = #{id}")
    @Results(value = {
            @Result(property="id", column="subproject_id"),
            @Result(property="activityId", column="subproject_activity_id"),
            @Result(property="name", column="subproject_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    SubProjectModel findById(long id);

    @Delete("DELETE FROM subproject WHERE subproject_id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO activity (activity_id, name, date_time_id) VALUES (#{activityId}, #{name}, #{dateTimeId});")
    @Options(useGeneratedKeys = true, keyColumn = "activity_id", keyProperty = "activityId")
    void createActivity(SubProjectModel subProjectModel);

    @Insert("INSERT INTO subproject (subproject_id, activity_id) VALUES (#{id}, #{activityId})")
    @Options(useGeneratedKeys = true, keyColumn = "subproject_id", keyProperty = "id")
    void createSubProject(SubProjectModel subProjectModel);

    @Insert("INSERT INTO subproject_task (subproject_id, task_id) VALUES (#{subProjectModel.id}, #{taskModel.id})")
    void addTaskToSubProject(SubProjectModel subProjectModel, TaskModel taskModel);

    @Select("SELECT * FROM task_view tv INNER JOIN subproject_task st ON tv.task_id=st.task_id WHERE subproject_id = #{id}")
    List<TaskModel> findTasksBySubProjectId(long id);
}
