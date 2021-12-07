package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.UserModel;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM user")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password")})
    List<UserModel> findAllUsers();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password")})
    UserModel findById(long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password")})
    UserModel findByUsername(String username);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(long id);

    // TODO:Make username unique and create a deleteByUsername(String username)

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    int updatePassword(UserModel userModel);

    @Insert("INSERT INTO user (id, username, password) VALUES (#{id}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void createUser(UserModel userModel);

    @Select("SELECT * FROM user WHERE username LIKE #{searchTerm}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password")})
    List<UserModel> findBySearchTerm(String searchTerm);
}

//@org.apache.ibatis.annotations.