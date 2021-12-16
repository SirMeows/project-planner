/*
Author He
13.12.2021
 */

package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.PersonModel;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PersonRepository {

    @Insert("INSERT INTO person (id, first_name, last_name) VALUES (#{id}, #{firstname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void createPerson(PersonModel personModel);

    @Select("SELECT * FROM person WHERE id = #{id}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="userId", column="user_id"),
            @Result(property="firstName", column="first_name"),
            @Result(property="lastName", column="last_name")})
    PersonModel findById(long id);


    @Update("UPDATE person SET first_name=#{firstname} WHERE id=#{id}")
    int updateFirstName(PersonModel personModel);

    @Update("UPDATE person SET last_name=#{lastname} WHERE id=#{id}")
    int updateLastName(PersonModel personModel);

    @Delete("DELETE FROM person WHERE id = #{id}")
    int deleteById(long id);

    @Select("SELECT * FROM person")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="userId", column="user_id"),
            @Result(property="firstName", column="first_name"),
            @Result(property="lastName", column="last_name")})
    List<PersonModel> findAllPersons();
}
