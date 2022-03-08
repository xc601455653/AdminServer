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
import xyz.wsyzz.candy.entity.model.SalaryDetails;
import xyz.wsyzz.candy.entity.TO.SalaryDetailsQueryTO;
import xyz.wsyzz.candy.service.SalaryDetailsService;
import xyz.wsyzz.candy.util.ResultDataUtils;

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
