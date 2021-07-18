package xyz.wsyzz.candy.controller;

import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.model.User;
import xyz.wsyzz.candy.mapper.RoleMenuMapper;
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

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @PostMapping("add")
    public ResultData addUser(User user){
        user.setPassword(ShiroEncryptUtils.encryptPassword(user.getPassword(),user.getUserName()));
        userService.addUser(user);
        return ResultDataUtils.success();
    }


    @PostMapping("login")
    public ResultData login(@RequestParam("userName")@ApiParam("用户名") String userName,@ApiParam("密码") @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        subject.login(usernamePasswordToken);
        return ResultDataUtils.success();
    }
}
