package xyz.wsyzz.candy.entity.TO;

import lombok.Data;
import xyz.wsyzz.candy.entity.BaseParam;

/**
 * Created by xucan on 2022/6/5.
 */
@Data
public class EmployeebasicinfoQueryTO extends BaseParam {

    private Integer employeeId;

    private String employeeName;
}
