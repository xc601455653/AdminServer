package xyz.wsyzz.candy.service;

import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.User;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public interface UserService {
    User findByUsername(String userName);
}
