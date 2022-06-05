package xyz.wsyzz.candy.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.constant.Webconstant;
import xyz.wsyzz.candy.entity.TO.UserQueryTO;
import xyz.wsyzz.candy.entity.model.Menu;
import xyz.wsyzz.candy.entity.model.User;
import xyz.wsyzz.candy.service.UserService;
import xyz.wsyzz.candy.shiro.ShiroEncryptUtils;
import xyz.wsyzz.candy.util.ResultDataUtils;

import java.util.List;

/**
 * Created by ${XC} on 2019/5/1.
 */
@RestController
@RequestMapping("user")
@Api(description = "系统用户信息服务", tags = {"UserController"})
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getstring")
    public String getstring (){
        return "================";
    }

    @ApiOperation("新增系统用户")
    @PostMapping("add")
    public ResultData addUser(@RequestBody User user){
        User byUsername = userService.findByUsername(user.getUserName());
        if (byUsername != null) {
            throw new RuntimeException("用户名已存在");
        }
        user.setPassword(ShiroEncryptUtils.encryptPassword(user.getPassword(),user.getUserName()));
        userService.addUser(user);
        return ResultDataUtils.success();
    }

    @ApiOperation("登录服务")
    @PostMapping("login")
    public ResultData login(@RequestParam("userName")@ApiParam("用户名") String userName,@ApiParam("密码") @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        subject.login(usernamePasswordToken);
        return ResultDataUtils.success();
    }

    @ApiOperation("系统用户列表")
    @PostMapping("list")
    public ResultData userList(@RequestBody UserQueryTO queryTO){
        if (queryTO.getPageNo() == null) {
            queryTO.setPageNo(Webconstant.PAGE_NO);
        }
        if (queryTO.getPageSize() == null) {
            queryTO.setPageSize(Webconstant.PAGE_SIZE);
        }
        PageInfo<User> users = userService.userList(queryTO);
        return ResultDataUtils.success(users);
    }

    @ApiOperation("用户菜单列表")
    @PostMapping("usermenus")
    public ResultData userMenus(@RequestBody UserQueryTO queryTO) {
        List<Menu> data = userService.getMenusByUser(queryTO);
        return ResultDataUtils.success(data);
    }
}
