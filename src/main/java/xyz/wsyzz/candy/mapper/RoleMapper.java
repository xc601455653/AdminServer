package xyz.wsyzz.candy.mapper;

import xyz.wsyzz.candy.entity.model.Role;
import xyz.wsyzz.candy.util.BaseMapper;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectByIds(List<Long> roleIds);
}