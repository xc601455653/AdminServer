package xyz.wsyzz.candy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.TO.EmpSalaryinfoQueryTO;
import xyz.wsyzz.candy.entity.model.EmpSalaryinfo;
import xyz.wsyzz.candy.mapper.EmpSalaryinfoMapper;
import xyz.wsyzz.candy.service.EmpSalaryinfoService;

import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class EmpSalaryinfoServiceImpl implements EmpSalaryinfoService {

    @Autowired
    private EmpSalaryinfoMapper empSalaryinfoMapper;


    @Override
    public int insert(EmpSalaryinfo empSalaryinfo) {
        return empSalaryinfoMapper.insert(empSalaryinfo);
    }

    @Override
    public int update(EmpSalaryinfo empSalaryinfo) {
        return empSalaryinfoMapper.updateByPrimaryKey(empSalaryinfo);
    }

    @Override
    public PageInfo<EmpSalaryinfo> list(EmpSalaryinfoQueryTO empSalaryinfoQueryTO) {
        Page<EmpSalaryinfo> page = PageHelper.startPage(empSalaryinfoQueryTO.getPageNo(), empSalaryinfoQueryTO.getPageSize());
        Example example = new Example(EmpSalaryinfo.class);
        example.and()
                .andEqualTo("employeeId", empSalaryinfoQueryTO.getEmployeeId());
        empSalaryinfoMapper.selectByExample(example);
        return page.toPageInfo();
    }
}
