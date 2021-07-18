package xyz.wsyzz.candy.mapper;

import xyz.wsyzz.candy.entity.model.Menu;
import xyz.wsyzz.candy.util.BaseMapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> selectByMenuIds(List<Long> menuIds);
}