package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.models.SubProjectModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubProjectRepository {

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

    @Select("SELECT * FROM subproject_view WHERE ")
    @Results(value = {
            @Result(property="id", column="subproject_id"),
            @Result(property="activityId", column="subproject_activity_id"),
            @Result(property="name", column="subproject_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    List<SubProjectModel> findSubProjectsByProjectId(long id);

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
    ProjectModel findById(long id);

    @Delete("DELETE FROM subproject WHERE subproject_id = #{id}")
    int deleteById(long id);

    @Update("UPDATE date_time SET planned_start_date = #{plannedStartDate} WHERE date_time_id = #{dateTimeId}")
    int updatePlannedStartDate(SubProjectModel subProjectModel);

    @Update("UPDATE date_time SET actual_start_date = #{actualStartDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualStartDate(SubProjectModel subProjectModel);

    @Update("UPDATE date_time SET deadline = #{deadline} WHERE date_time_id = #{dateTimeId}")
    int updateDeadline(SubProjectModel subProjectModel);

    @Update("UPDATE date_time SET actual_end_date = #{actualEndDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualEndDate(SubProjectModel subProjectModel);

    @Insert("INSERT INTO date_time (date_time_id, planned_start_date, actual_start_date, deadline, actual_end_date)" +
            "VALUES (#{dateTimeId}, #{plannedStartDate}, #{actualStartDate}, #{deadline}, #{actualEndDate})")
    @Options(useGeneratedKeys = true, keyColumn = "date_time_id", keyProperty = "dateTimeId")
    void createDateTime(SubProjectModel subProjectModel);

    @Insert("INSERT INTO activity (activity_id, name, date_time_id) VALUES (#{activityId}, #{name}, #{dateTimeId});")
    @Options(useGeneratedKeys = true, keyColumn = "activity_id", keyProperty = "activityId")
    void createActivity(SubProjectModel subProjectModel);

    @Insert("INSERT INTO subproject (subproject_id, activity_id) VALUES (#{id}, #{activityId})")
    @Options(useGeneratedKeys = true, keyColumn = "subproject_id", keyProperty = "id")
    void createSubProject(SubProjectModel subProjectModel);
}
