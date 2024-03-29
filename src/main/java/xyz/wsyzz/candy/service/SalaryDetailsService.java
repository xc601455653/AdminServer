package xyz.wsyzz.candy.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.model.SalaryDetails;
import xyz.wsyzz.candy.entity.TO.SalaryDetailsQueryTO;

import java.util.List;
import java.util.Set;

/**
 * Created by xucan on 2022/2/26.
 */
@Service
public interface SalaryDetailsService {

    /**
     * 新增薪资明细
     * @param salaryDetails
     * @return
     */
    int addSalaryDetails(SalaryDetails salaryDetails);

    /**
     * 删除薪资明细
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 更新薪资明细
     * @param salaryDetails
     * @return
     */
    int updateById(SalaryDetails salaryDetails);

    /**
     * 薪资明细条件查询
     * @param salaryDetailsQueryTO
     * @return
     */
    PageInfo<SalaryDetails> list(SalaryDetailsQueryTO salaryDetailsQueryTO);

    /**
     * 根据条件查询总数
     * @param salaryDetails
     * @return
     */
    int selectCount(SalaryDetails salaryDetails);

    /**
     * 根据主键查询数据
     * @param id
     * @return
     */
    SalaryDetails selectByPrimaryKey(Integer id);

    /**
     * 根据名称查询是否有重复的数据
     * @param collect
     * @return
     */
    List<String> checkSalaryDetailsName(Set<String> collect);

    /**
     * 批量插入工资详情数据
     * @param datalist
     */
    int insertSalaryDetailsList(List<SalaryDetails> datalist);

    /**
     * 根据id集合查询薪资明细
     * @param salaryDetailIds
     * @return
     */
    List<SalaryDetails> selectListByIds(String salaryDetailIds);
}
