package xyz.wsyzz.candy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.TO.UserQueryTO;
import xyz.wsyzz.candy.entity.model.Menu;
import xyz.wsyzz.candy.entity.model.User;
import xyz.wsyzz.candy.mapper.MenuMapper;
import xyz.wsyzz.candy.mapper.UserMapper;
import xyz.wsyzz.candy.service.UserService;
import xyz.wsyzz.candy.util.CommonUtils;

import java.util.List;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

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

    @Override
    public PageInfo<User> userList(UserQueryTO queryTO) {
        Page<User> page = PageHelper.startPage(queryTO.getPageNo(), queryTO.getPageSize());
        Example example = new Example(User.class);
        example.and().andEqualTo("id", queryTO.getId()).andLike("userName", "%" + queryTO.getUserName() + "%");
        List<User> userList = userMapper.selectByExample(example);
        return page.toPageInfo();
    }

    @Override
    public List<Menu> getMenusByUser(UserQueryTO queryTO) {
        List<Menu> data = menuMapper.getMenusByUser(queryTO);
        List<Menu> treeData = CommonUtils.buildTreeData(data, Menu::getParamId, Menu::getParamPId, item -> item::setChildren, 0L);
        return treeData;
    }
}
