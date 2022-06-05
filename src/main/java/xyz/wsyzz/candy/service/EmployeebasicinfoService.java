package xyz.wsyzz.candy.service;

import com.github.pagehelper.PageInfo;
import xyz.wsyzz.candy.entity.TO.EmployeebasicinfoQueryTO;
import xyz.wsyzz.candy.entity.model.Employeebasicinfo;

import java.util.List;

/**
 * Created by xucan on 2022/6/5.
 */
public interface EmployeebasicinfoService {

    int insert(Employeebasicinfo employeebasicinfo);

    int update(Employeebasicinfo employeebasicinfo);

    int updateByPrimaryKeySelective(Employeebasicinfo employeebasicinfo);

    PageInfo<Employeebasicinfo> list(EmployeebasicinfoQueryTO employeebasicinfoQueryTO);
}
