package xyz.wsyzz.candy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.model.SalaryDetails;
import xyz.wsyzz.candy.entity.SalaryDetailsQueryTO;
import xyz.wsyzz.candy.mapper.SalaryDetailsMapper;
import xyz.wsyzz.candy.service.SalaryDetailsService;

/**
 * Created by xucan on 2022/2/26.
 */
@Service
public class SalaryDetailsServiceImpl implements SalaryDetailsService {

    @Autowired
    private SalaryDetailsMapper salaryDetailsMapper;

    @Override
    public int addSalaryDetails(SalaryDetails salaryDetails) {
        return salaryDetailsMapper.insert(salaryDetails);
    }

    @Override
    public int deleteById(Integer id) {
        return salaryDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(SalaryDetails salaryDetails) {
        return salaryDetailsMapper.updateByPrimaryKey(salaryDetails);
    }

    @Override
    public PageInfo<SalaryDetails> list(SalaryDetailsQueryTO salaryDetailsQueryTO) {
        Page<SalaryDetails> page = PageHelper.startPage(salaryDetailsQueryTO.getPageNo(), salaryDetailsQueryTO.getPageSize());
        Example example = new Example(SalaryDetails.class);
        example.and()
                .andEqualTo("id", salaryDetailsQueryTO.getId())
                .andLike("name","%".concat(salaryDetailsQueryTO.getName()).concat("%"));
        salaryDetailsMapper.selectByExample(example);
        return page.toPageInfo();

    }

    @Override
    public int selectCount(SalaryDetails salaryDetails) {
        return salaryDetailsMapper.selectCount(salaryDetails);
    }

    @Override
    public SalaryDetails selectByPrimaryKey(Integer id) {
        return salaryDetailsMapper.selectByPrimaryKey(id);
    }
}
