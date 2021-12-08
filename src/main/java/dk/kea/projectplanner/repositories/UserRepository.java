package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.PersonModel;
import dk.kea.projectplanner.models.UserModel;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserRepository {

    @Insert("INSERT INTO user (id, username, password, person_id) VALUES (#{id}, #{username}, #{password}, #{personId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void createUser(UserModel userModel, PersonModel personModel);

    @Select("SELECT * FROM user")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password"),
        @Result(property="personId", column = "person_id")})
    List<UserModel> findAllUsers();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password"),
        @Result(property="personId", column = "person_id")})
    UserModel findById(long id);

    @Select("SELECT * FROM user WHERE username LIKE #{searchTerm}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password"),
            @Result(property="personId", column = "person_id")})
    List<UserModel> findBySearchTerm(String searchTerm);

    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password"),
            @Result(property="personId", column = "person_id")})
    UserModel findByUsername(String username);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    int updatePassword(UserModel userModel);
}

//@org.apache.ibatis.annotations.