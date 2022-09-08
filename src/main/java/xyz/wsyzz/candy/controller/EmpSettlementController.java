package xyz.wsyzz.candy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.TO.EmpSettlementQueryTO;
import xyz.wsyzz.candy.entity.model.EmpSettlement;
import xyz.wsyzz.candy.service.EmpSettlementService;
import xyz.wsyzz.candy.util.ResultDataUtils;

/**
 * Created by xucan on 2022/6/5.
 */
@RestController
@RequestMapping("empsettlement")
public class EmpSettlementController {

    @Autowired
    private EmpSettlementService empSettlementService;


    @PostMapping("insert")
    public ResultData insert(@RequestBody EmpSettlement empSettlement) {
        int insert = empSettlementService.insert(empSettlement);
        return ResultDataUtils.success(insert);
    }

    @PostMapping("update")
    public ResultData update(@RequestBody EmpSettlement empSettlement) {
        int update = empSettlementService.update(empSettlement);
        return ResultDataUtils.success(update);
    }

    @PostMapping("list")
    public ResultData list(@RequestBody EmpSettlementQueryTO empSettlementQueryTO) {
        PageInfo<EmpSettlement> list = empSettlementService.list(empSettlementQueryTO);
        return ResultDataUtils.success(list);
    }
}
