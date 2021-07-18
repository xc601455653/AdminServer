package xyz.wsyzz.candy.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import xyz.wsyzz.candy.entity.model.Menu;
import xyz.wsyzz.candy.util.BaseMapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectByMenuIds(@Param("menuIds") List<Long> menuIds);
}