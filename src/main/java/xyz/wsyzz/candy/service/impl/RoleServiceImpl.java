package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import xyz.wsyzz.candy.entity.model.Role;
import xyz.wsyzz.candy.entity.model.UserRole;
import xyz.wsyzz.candy.mapper.RoleMapper;
import xyz.wsyzz.candy.mapper.UserRoleMapper;
import xyz.wsyzz.candy.service.RoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public Set<Role> getRolesByUserId(Long id) {
        UserRole userRole = new UserRole();
        userRole.setUserId(id);
        List<UserRole> select = userRoleMapper.select(userRole);
        if(CollectionUtils.isEmpty(select)) return new HashSet<>();
        List<Long> roleIds = select.stream().map(e -> e.getRoelId()).collect(Collectors.toList());
        List<Role> roles = roleMapper.selectByIds(roleIds);
        return new HashSet<>(roles);
    }
}
