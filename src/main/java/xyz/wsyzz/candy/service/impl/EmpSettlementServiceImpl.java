package xyz.wsyzz.candy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.TO.EmpSettlementQueryTO;
import xyz.wsyzz.candy.entity.model.EmpSettlement;
import xyz.wsyzz.candy.mapper.EmpSettlementMapper;
import xyz.wsyzz.candy.service.EmpSettlementService;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class EmpSettlementServiceImpl implements EmpSettlementService {

    @Autowired
    private EmpSettlementMapper empSettlementMapper;


    @Override
    public int insert(EmpSettlement empSettlement) {
        return empSettlementMapper.insert(empSettlement);
    }

    @Override
    public int update(EmpSettlement empSettlement) {
        return empSettlementMapper.updateByPrimaryKey(empSettlement);
    }

    @Override
    public PageInfo<EmpSettlement> list(EmpSettlementQueryTO empSettlementQueryTO) {
        Page<EmpSettlement> page = PageHelper.startPage(empSettlementQueryTO.getPageNo(), empSettlementQueryTO.getPageSize());
        Example example = new Example(EmpSettlement.class);
        example.and()
                .andEqualTo("employeeId", empSettlementQueryTO.getEmployeeId());
        empSettlementMapper.selectByExample(example);
        return page.toPageInfo();
    }
}
