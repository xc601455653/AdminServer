package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.model.Menu;
import xyz.wsyzz.candy.entity.model.RoleMenu;
import xyz.wsyzz.candy.mapper.MenuMapper;
import xyz.wsyzz.candy.mapper.RoleMenuMapper;
import xyz.wsyzz.candy.service.MenuService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Override
    public Set<Menu> getMenusByRoleId(Long id) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(id);
        List<RoleMenu> roleMenus = roleMenuMapper.select(roleMenu);
        List<Long> menuIds = roleMenus.stream().map(e -> e.getMenuId()).collect(Collectors.toList());
        List<Menu> menus= menuMapper.selectByMenuIds(menuIds);
        return new HashSet<>(menus);
    }
}
