package moveon.studentManager.service.impl;

import moveon.studentManager.mapper.UserMapper;
import moveon.studentManager.pojo.User;
import moveon.studentManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> loginUser(String username, String password) {
        return userMapper.findUser(username,password);
    }

    @Override
    public boolean registerUser(User user) {
        try{
            userMapper.insertUser(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void modifyPassword(String id, String newPassword) {
        userMapper.modifyPassword(id,newPassword);
    }
}
