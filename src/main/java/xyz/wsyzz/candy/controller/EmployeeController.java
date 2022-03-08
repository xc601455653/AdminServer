package xyz.wsyzz.candy.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.constant.Webconstant;
import xyz.wsyzz.candy.entity.model.Employee;
import xyz.wsyzz.candy.entity.EmployeeQueryTO;
import xyz.wsyzz.candy.service.EmployeeService;
import xyz.wsyzz.candy.util.ResultDataUtils;

/**
 * Created by xucan on 2022/2/26.
 */
@RestController
@RequestMapping("employee")
@Api(description = "人员信息相关服务", tags = {"EmployeeController"})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("新增人员服务")
    @PostMapping("add")
    public ResultData add(@RequestBody Employee employee) {
        if (StringUtils.isEmpty(employee.getEmployeeName())) {
            return ResultDataUtils.exception("人员名称不能为空");
        }
        Employee queryByName = new Employee();
        queryByName.setEmployeeName(employee.getEmployeeName());
        int selectCount = employeeService.selectCount(queryByName);
        if (selectCount > 0) {
            return ResultDataUtils.exception("人员名称已存在");
        }
        employeeService.addEmployee(employee);
        return ResultDataUtils.success();
    }

    @ApiOperation("删除人员")
    @PostMapping("delete")
    public ResultData delete(@RequestBody Employee employee) {
        if (employee.getEmployeeId() == null) {
            return ResultDataUtils.exception("EmployeeId不能为空");
        }
        Employee employeeInfo = employeeService.selectByPrimaryKey(employee.getEmployeeId());
        if (employeeInfo == null) {
            return ResultDataUtils.exception("EmployeeId数据不存在");
        }
        employeeService.deleteById(employee.getEmployeeId());
        return ResultDataUtils.success();
    }

    @ApiOperation("更新人员信息")
    @PostMapping("update")
    public ResultData update(@RequestBody Employee employee) {
        if (employee.getEmployeeId() == null) {
            return ResultDataUtils.exception("EmployeeId不能为空");
        }
        Employee employeeInfo = employeeService.selectByPrimaryKey(employee.getEmployeeId());
        if (employeeInfo == null) {
            return ResultDataUtils.exception("EmployeeId数据不存在");
        }
        employeeService.updateById(employee);
        return ResultDataUtils.success();
    }

    @ApiOperation("人员信息查询")
    @PostMapping("list")
    public ResultData list(@RequestBody EmployeeQueryTO employeeQueryTO) {
        if (employeeQueryTO.getPageNo() == null) {
            employeeQueryTO.setPageNo(Webconstant.PAGE_NO);
        }
        if (employeeQueryTO.getPageSize() == null) {
            employeeQueryTO.setPageSize(Webconstant.PAGE_SIZE);
        }
        PageInfo<Employee> pageInfo = employeeService.list(employeeQueryTO);
        return ResultDataUtils.success(pageInfo);
    }

}
