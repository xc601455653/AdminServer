package xyz.wsyzz.candy.service;

import com.github.pagehelper.PageInfo;
import xyz.wsyzz.candy.entity.TO.EmpSalaryinfoQueryTO;
import xyz.wsyzz.candy.entity.model.EmpSalaryinfo;

/**
 * Created by xucan on 2022/6/5.
 */
public interface EmpSalaryinfoService {

    int insert(EmpSalaryinfo empSalaryinfo);

    int update(EmpSalaryinfo empSalaryinfo);

    PageInfo<EmpSalaryinfo> list(EmpSalaryinfoQueryTO empSalaryinfoQueryTO);
}
