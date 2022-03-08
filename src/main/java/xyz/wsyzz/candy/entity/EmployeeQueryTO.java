package xyz.wsyzz.candy.entity;

import lombok.Data;

/**
 * Created by xucan on 2022/2/26.
 */
@Data
public class EmployeeQueryTO extends BaseParam {
    /**
     * 人员名称
     */
    private String employeeName;

    /**
     * 序号
     */
    private Integer employeeId;
}
