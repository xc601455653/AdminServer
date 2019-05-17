package xyz.wsyzz.candy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
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


    @GetMapping("login")
    public Object login(String userName,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        subject.login(usernamePasswordToken);
        return null;
    }
}
