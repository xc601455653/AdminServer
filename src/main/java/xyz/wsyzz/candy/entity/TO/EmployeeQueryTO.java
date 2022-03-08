package xyz.wsyzz.candy.entity.TO;

import lombok.Data;
import xyz.wsyzz.candy.entity.BaseParam;

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
