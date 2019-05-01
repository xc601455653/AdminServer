package xyz.wsyzz.candy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.mapper.UserMapper;

import java.util.List;

/**
 * Created by ${XC} on 2019/5/1.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    /**
     * 测试
     * @return
     */
    @GetMapping("list")
    public Object getUserList(){
        return userMapper.selectAll();
    }
}
