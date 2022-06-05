package xyz.wsyzz.candy.service;

import com.github.pagehelper.PageInfo;
import xyz.wsyzz.candy.entity.TO.EmpSettlementQueryTO;
import xyz.wsyzz.candy.entity.model.EmpSettlement;

/**
 * Created by xucan on 2022/6/5.
 */
public interface EmpSettlementService {

    int insert(EmpSettlement empSettlement);

    int update(EmpSettlement empSettlement);

    PageInfo<EmpSettlement> list(EmpSettlementQueryTO empSettlementQueryTO);
}
