package xyz.wsyzz.candy.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * Created by ${XC} on 2019/5/1.
 */

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
