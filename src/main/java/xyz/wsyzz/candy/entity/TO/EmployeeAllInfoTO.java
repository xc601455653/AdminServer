package xyz.wsyzz.candy.entity.TO;

import lombok.Data;
import xyz.wsyzz.candy.entity.model.EmpSalaryinfo;
import xyz.wsyzz.candy.entity.model.EmpSettlement;
import xyz.wsyzz.candy.entity.model.Employeebasicinfo;

/**
 * Created by xucan on 2022/6/5.
 */
@Data
public class EmployeeAllInfoTO {

    private Employeebasicinfo employeebasicinfo;

    private EmpSalaryinfo empSalaryinfo;

    private EmpSettlement empSettlement;

}
