package moveon.studentManager.service;

import moveon.studentManager.pojo.User;

import java.util.List;


public interface UserService {

    /**
     * 学生登陆方法
     * @param username
     * @param password
     * @return
     */
    List<User> loginUser(String username, String password);

    /**
     * 用户注册方法
     * @return
     */
    boolean registerUser(User user);

    /**
     * 修改用户密码
     * @param id
     * @param newPassword
     */
    void modifyPassword(String id,String newPassword);
}
