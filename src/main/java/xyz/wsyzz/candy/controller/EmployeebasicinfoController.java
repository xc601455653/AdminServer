package xyz.wsyzz.candy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.TO.EmployeebasicinfoQueryTO;
import xyz.wsyzz.candy.entity.model.Employeebasicinfo;
import xyz.wsyzz.candy.service.EmployeebasicinfoService;
import xyz.wsyzz.candy.util.ResultDataUtils;

/**
 * Created by xucan on 2022/6/5.
 */
@RestController
@RequestMapping("employeebasicinfo")
public class EmployeebasicinfoController {

    @Autowired
    private EmployeebasicinfoService employeebasicinfoService;


    @PostMapping("insert")
    public ResultData insert(@RequestBody Employeebasicinfo employeebasicinfo) {
        int insert = employeebasicinfoService.insert(employeebasicinfo);
        return ResultDataUtils.success(insert);
    }


    @PostMapping("update")
    public ResultData update(@RequestBody Employeebasicinfo employeebasicinfo) {
        int update = employeebasicinfoService.update(employeebasicinfo);
        return ResultDataUtils.success(update);
    }


    @PostMapping("list")
    public ResultData list(@RequestBody EmployeebasicinfoQueryTO employeebasicinfoQueryTO) {
        PageInfo<Employeebasicinfo> list = employeebasicinfoService.list(employeebasicinfoQueryTO);
        return ResultDataUtils.success(list);
    }
}
