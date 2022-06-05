package xyz.wsyzz.candy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.TO.EmployeebasicinfoQueryTO;
import xyz.wsyzz.candy.entity.model.Employeebasicinfo;
import xyz.wsyzz.candy.mapper.EmployeebasicinfoMapper;
import xyz.wsyzz.candy.service.EmployeebasicinfoService;

import java.util.List;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class EmployeebasicinfoServiceImpl implements EmployeebasicinfoService {

    @Autowired
    private EmployeebasicinfoMapper employeebasicinfoMapper;


    @Override
    public int insert(Employeebasicinfo employeebasicinfo) {
        return employeebasicinfoMapper.insert(employeebasicinfo);
    }

    @Override
    public int update(Employeebasicinfo employeebasicinfo) {
        return employeebasicinfoMapper.updateByPrimaryKey(employeebasicinfo);
    }

    @Override
    public int updateByPrimaryKeySelective(Employeebasicinfo employeebasicinfo) {
        return employeebasicinfoMapper.updateByPrimaryKeySelective(employeebasicinfo);
    }

    @Override
    public PageInfo<Employeebasicinfo> list(EmployeebasicinfoQueryTO employeebasicinfoQueryTO) {
        Page<Employeebasicinfo> page = PageHelper.startPage(employeebasicinfoQueryTO.getPageNo(), employeebasicinfoQueryTO.getPageSize());
        Example example = new Example(Employeebasicinfo.class);
        example.and()
                .andEqualTo("employeeId", employeebasicinfoQueryTO.getEmployeeId())
                .andLike("employeeName","%".concat(employeebasicinfoQueryTO.getEmployeeName()).concat("%"));
        employeebasicinfoMapper.selectByExample(example);
        return page.toPageInfo();
    }


}
