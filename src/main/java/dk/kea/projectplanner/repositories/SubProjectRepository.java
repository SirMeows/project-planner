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
}
