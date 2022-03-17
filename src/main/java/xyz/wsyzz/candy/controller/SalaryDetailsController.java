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
import xyz.wsyzz.candy.entity.model.SalaryDetails;
import xyz.wsyzz.candy.entity.TO.SalaryDetailsQueryTO;
import xyz.wsyzz.candy.service.SalaryDetailsService;
import xyz.wsyzz.candy.util.ResultDataUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xucan on 2022/2/26.
 */
@RestController
@RequestMapping("salarydetails")
@Api(description = "工资明细相关服务", tags = {"SalaryDetailsController"})
public class SalaryDetailsController {

    @Autowired
    private SalaryDetailsService salaryDetailsService;

    @ApiOperation("新增工资明细")
    @PostMapping("add")
    public ResultData add(@RequestBody SalaryDetails salaryDetails) {
        if (StringUtils.isEmpty(salaryDetails.getName())) {
            return ResultDataUtils.exception("名称不能为空");
        }
        int selectCount = salaryDetailsService.selectCount(salaryDetails);
        if (selectCount > 0) {
            return ResultDataUtils.exception("名称已存在");
        }
        salaryDetailsService.addSalaryDetails(salaryDetails);
        return ResultDataUtils.success();
    }

    @ApiOperation("批量新增工资明细")
    @PostMapping("addlist")
    public ResultData addlist(@RequestBody BatchAddTO<SalaryDetails> batchAddTO) {
        List<SalaryDetails> datalist = batchAddTO.getDatalist();
        if (datalist == null || datalist.size() == 0) {
            ResultDataUtils.exception("新增数据不能为空");
        }
        // 校验名称是否重复,先判断数据中是否有相同名称的，再用名称查询是否有重复数据
        Set<String> collect = datalist.stream().map(item -> item.getName()).collect(Collectors.toSet());
        if (collect.size() < datalist.size()) {
            return ResultDataUtils.exception("导入数据中的名称不能重复");
        }
        List<String> names = salaryDetailsService.checkSalaryDetailsName(collect);
        if (names.size() > 0) {
            ResultDataUtils.exception(String.format("%s这些人员名称喝数据库中有重复，请处理",String.join(",",names)));
        }
        salaryDetailsService.insertSalaryDetailsList(datalist);

        return ResultDataUtils.success();
    }

    @ApiOperation("删除工资明细")
    @PostMapping("delete")
    public ResultData delete(@RequestBody SalaryDetails salaryDetails) {
        if (salaryDetails.getId() == null) {
            return ResultDataUtils.exception("id不能为空");
        }
        SalaryDetails salaryDetailsInfo = salaryDetailsService.selectByPrimaryKey(salaryDetails.getId());
        if (salaryDetailsInfo == null) {
            return ResultDataUtils.exception("数据不存在");
        }
        salaryDetailsService.deleteById(salaryDetails.getId());
        return ResultDataUtils.success();
    }

    @ApiOperation("更新工资明细信息")
    @PostMapping("update")
    public ResultData update(@RequestBody SalaryDetails salaryDetails) {
        if (salaryDetails.getId() == null) {
            return ResultDataUtils.exception("id不能为空");
        }
        SalaryDetails salaryDetailsInfo = salaryDetailsService.selectByPrimaryKey(salaryDetails.getId());
        if (salaryDetailsInfo == null) {
            return ResultDataUtils.exception("数据不存在");
        }
        salaryDetailsService.updateById(salaryDetails);
        return ResultDataUtils.success();
    }

    @ApiOperation("查询工资明细列表")
    @PostMapping("list")
    public ResultData list(@RequestBody SalaryDetailsQueryTO salaryDetailsQueryTO) {
        if (salaryDetailsQueryTO.getPageNo() == null) {
            salaryDetailsQueryTO.setPageNo(Webconstant.PAGE_NO);
        }
        if (salaryDetailsQueryTO.getPageSize() == null) {
            salaryDetailsQueryTO.setPageSize(Webconstant.PAGE_SIZE);
        }
        PageInfo<SalaryDetails> pageInfo = salaryDetailsService.list(salaryDetailsQueryTO);
        return ResultDataUtils.success(pageInfo);
    }
}
