package xyz.wsyzz.candy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.TO.EmpSalaryinfoQueryTO;
import xyz.wsyzz.candy.entity.model.EmpSalaryinfo;
import xyz.wsyzz.candy.service.EmpSalaryinfoService;
import xyz.wsyzz.candy.util.ResultDataUtils;

/**
 * Created by xucan on 2022/6/5.
 */
@RestController
@RequestMapping("empsalaryinfo")
public class EmpSalaryinfoController {

    @Autowired
    private EmpSalaryinfoService empSalaryinfoService;

    @PostMapping("insert")
    public ResultData insert(@RequestBody EmpSalaryinfo empSalaryinfo) {
        int insert = empSalaryinfoService.insert(empSalaryinfo);
        return ResultDataUtils.success(insert);
    }

    @PostMapping("update")
    public ResultData update(@RequestBody EmpSalaryinfo empSalaryinfo) {
        int update = empSalaryinfoService.update(empSalaryinfo);
        return ResultDataUtils.success(update);
    }

    @PostMapping("list")
    public ResultData list(@RequestBody EmpSalaryinfoQueryTO empSalaryinfoQueryTO) {
        PageInfo<EmpSalaryinfo> list = empSalaryinfoService.list(empSalaryinfoQueryTO);
        return ResultDataUtils.success(list);
    }

}
