package xyz.wsyzz.candy.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.model.SalaryDetails;
import xyz.wsyzz.candy.entity.TO.SalaryDetailsQueryTO;
import xyz.wsyzz.candy.mapper.SalaryDetailsMapper;
import xyz.wsyzz.candy.service.SalaryDetailsService;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public List<String> checkSalaryDetailsName(Set<String> collect) {
        if (collect.size() == 0) {
            return new ArrayList<>();
        }
        Example example = new Example(SalaryDetails.class);
        example.and().andIn("name", collect).andEqualTo(Integer.valueOf(DateUtil.format(new Date(), "YYYYMM")));
        List<SalaryDetails> employees = salaryDetailsMapper.selectByExample(example);
        List<String> stringList = employees.stream().map(item -> item.getName()).collect(Collectors.toList());
        return stringList;
    }

    @Override
    public int insertSalaryDetailsList(List<SalaryDetails> datalist) {
        return salaryDetailsMapper.insertList(datalist);
    }

    @Override
    public List<SalaryDetails> selectListByIds(String salaryDetailIds) {
        if (StringUtils.isEmpty(salaryDetailIds)) {
            return new ArrayList<>();
        }
        Example example = new Example(SalaryDetails.class);
        example.and().andIn("id", Arrays.asList(salaryDetailIds.split(",")));
        List<SalaryDetails> employees = salaryDetailsMapper.selectByExample(example);
        return employees;
    }
}
