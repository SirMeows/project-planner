package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM user")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password")})
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(value = {
        @Result(property="id", column="id"),
        @Result(property="username", column="username"),
        @Result(property="password", column="password")})
    User findUserById(long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password")})
    User findUserByUsername(String username);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    int updatePassword(User user);

    @Insert("INSERT INTO user (id, username, password) VALUES (#{id}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(User user);

    @Select("SELECT * FROM user WHERE username LIKE #{searchTerm}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password")})
    List<User> searchUserByUsername(String searchTerm);
}

//@org.apache.ibatis.annotations.