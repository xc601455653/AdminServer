package xyz.wsyzz.candy.entity.TO;

import lombok.Data;
import xyz.wsyzz.candy.entity.BaseParam;

/**
 * Created by xucan on 2022/2/26.
 */
@Data
public class SalaryDetailsQueryTO extends BaseParam {
    /**
     * 姓名
     */
    private String name;

    /**
     * 序号
     */
    private Integer id;
}
