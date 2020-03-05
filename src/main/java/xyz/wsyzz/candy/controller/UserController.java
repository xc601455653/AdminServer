package xyz.wsyzz.candy.controller;

import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.entity.User;
import xyz.wsyzz.candy.service.UserService;
import xyz.wsyzz.candy.shiro.ShiroEncryptUtils;
import xyz.wsyzz.candy.util.ResultDataUtils;

/**
 * Created by ${XC} on 2019/5/1.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("add")
    public Object addUser(User user){
        user.setPassword(ShiroEncryptUtils.encryptPassword(user.getPassword(),user.getUserName()));
        userService.addUser(user);
        return ResultDataUtils.success();
    }


    @PostMapping("login")
    public Object login(@RequestParam("userName")@ApiParam("用户名") String userName,@ApiParam("密码") @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        subject.login(usernamePasswordToken);
        return ResultDataUtils.success();
    }
}
