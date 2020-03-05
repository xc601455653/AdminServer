package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.User;
import xyz.wsyzz.candy.mapper.UserMapper;
import xyz.wsyzz.candy.service.UserService;

import java.util.List;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String userName) {
        User user = new User();
        user.setUserName(userName);
        List<User> select = userMapper.select(user);
        return select.size()>0?select.get(0):null;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
