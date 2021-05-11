package moveon.studentManager.mapper;

import moveon.studentManager.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 用户登陆
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    List<User> findUser(@Param("username") String username, @Param("password") String password);

    /**
     * 用户注册
     * @param user
     */
    @Insert("insert into user(username,password,type,name,email) values(#{username},#{password},#{type},#{name},#{email})")
    void insertUser(User user);

    /**
     * 修改用户密码
     * @param id
     * @param newPassword
     */
    @Update("UPDATE user SET password = '${newPassword}' where id = ${id}")
    void modifyPassword(@Param("id") String id,@Param("newPassword") String newPassword);
}
