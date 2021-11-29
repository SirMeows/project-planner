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
    List<UserModel> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password")})
    UserModel findUserById(long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password")})
    UserModel findUserByUsername(String username);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    int updatePassword(UserModel userModel);

    @Insert("INSERT INTO user (id, username, password) VALUES (#{id}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(UserModel userModel);

    @Select("SELECT * FROM user WHERE username LIKE #{searchTerm}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password")})
    List<UserModel> searchUserByUsername(String searchTerm);
}

//@org.apache.ibatis.annotations.