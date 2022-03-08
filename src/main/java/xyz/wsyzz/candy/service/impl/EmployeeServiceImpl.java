package xyz.wsyzz.candy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.model.Employee;
import xyz.wsyzz.candy.entity.EmployeeQueryTO;
import xyz.wsyzz.candy.mapper.EmployeeMapper;
import xyz.wsyzz.candy.service.EmployeeService;

/**
 * Created by xucan on 2022/2/26.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int deleteById(Integer employeeId) {
        return employeeMapper.deleteByPrimaryKey(employeeId);
    }

    @Override
    public int updateById(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public PageInfo<Employee> list(EmployeeQueryTO employeeQueryTO) {
        Page<Employee> page = PageHelper.startPage(employeeQueryTO.getPageNo(), employeeQueryTO.getPageSize());
        Example example = new Example(Employee.class);
        example.and()
                .andEqualTo("employeeId", employeeQueryTO.getEmployeeId())
                .andLike("employeeName","%".concat(employeeQueryTO.getEmployeeName()).concat("%"));
        employeeMapper.selectByExample(example);
        return page.toPageInfo();
    }

    @Override
    public int selectCount(Employee employee) {
        return employeeMapper.selectCount(employee);
    }

    @Override
    public Employee selectByPrimaryKey(Integer employeeId) {
        return employeeMapper.selectByPrimaryKey(employeeId);
    }
}
