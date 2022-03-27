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
import xyz.wsyzz.candy.entity.TO.BatchAddTO;
import xyz.wsyzz.candy.entity.model.Employee;
import xyz.wsyzz.candy.entity.TO.EmployeeQueryTO;
import xyz.wsyzz.candy.service.EmployeeService;
import xyz.wsyzz.candy.util.ResultDataUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @ApiOperation("批量新增人员服务")
    @PostMapping("addlist")
    public ResultData addlist(@RequestBody BatchAddTO<Employee> batchAddTO) {
        List<Employee> datalist = batchAddTO.getDatalist();
        if (datalist == null || datalist.size() == 0) {
            ResultDataUtils.exception("新增数据不能为空");
        }
        // 校验名称是否重复,先判断数据中是否有相同名称的，再用名称查询是否有重复数据
        Set<String> collect = datalist.stream().map(item -> item.getEmployeeName()).collect(Collectors.toSet());
        if (collect.size() < datalist.size()) {
            return ResultDataUtils.exception("导入数据中的人员名称不能重复");
        }
        List<String> names = employeeService.checkEmployeeName(collect);
        if (names.size() > 0) {
            return ResultDataUtils.exception(String.format("%s这些人员名称喝数据库中有重复，请处理",String.join(",",names)));
        }
        employeeService.insertEmployeeList(datalist);
        return ResultDataUtils.success();
    }

    @ApiOperation("删除人员")
    @PostMapping("delete")
    public ResultData delete(@RequestBody Employee employee) {
        if (employee.getEmployeeId() == null) {
            return ResultDataUtils.exception("Id不能为空");
        }
        Employee employeeInfo = employeeService.selectByPrimaryKey(employee.getId());
        if (employeeInfo == null) {
            return ResultDataUtils.exception("数据不存在");
        }
        employeeService.deleteById(employee.getId());
        return ResultDataUtils.success();
    }

    @ApiOperation("更新人员信息")
    @PostMapping("update")
    public ResultData update(@RequestBody Employee employee) {
        if (employee.getEmployeeId() == null) {
            return ResultDataUtils.exception("Id不能为空");
        }
        Employee employeeInfo = employeeService.selectByPrimaryKey(employee.getId());
        if (employeeInfo == null) {
            return ResultDataUtils.exception("数据不存在");
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
