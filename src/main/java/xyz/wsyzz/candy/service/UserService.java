package xyz.wsyzz.candy.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.TO.UserQueryTO;
import xyz.wsyzz.candy.entity.model.User;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public interface UserService {
    User findByUsername(String userName);

    int addUser(User user);

    PageInfo<User> userList(UserQueryTO queryTO);
}
