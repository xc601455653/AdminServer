package xyz.wsyzz.candy.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.model.Employee;
import xyz.wsyzz.candy.entity.TO.EmployeeQueryTO;

import java.util.List;
import java.util.Set;

/**
 * Created by xucan on 2022/2/26.
 */
@Service
public interface EmployeeService {
    /**
     * 新增人员信息
     * @param employee
     * @return
     */
    int addEmployee(Employee employee);

    /**
     * 根据id删除人员信息
     * @param employeeId
     * @return
     */
    int deleteById(Integer employeeId);

    /**
     * 更新人员信息
     * @param employee
     * @return
     */
    int updateById(Employee employee);

    /**
     * 人员信息条件查询
     * @param employeeQueryTO
     * @return
     */
    PageInfo<Employee> list(EmployeeQueryTO employeeQueryTO);

    /**
     * 根据实体条件查询总数
     * @param employee
     * @return
     */
    int selectCount(Employee employee);

    /**
     * 根据主键查询数据
     * @param employeeId
     * @return
     */
    Employee selectByPrimaryKey(Integer employeeId);

    /**
     * 批量新增
     * @param datalist
     * @return
     */
    int insertEmployeeList(List<Employee> datalist);

    /**
     * 检查重复的人员名称
     * @param collect
     * @return
     */
    List<String> checkEmployeeName(Set<String> collect);
}
