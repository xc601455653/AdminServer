package xyz.wsyzz.candy.entity.TO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by xucan on 2022/3/25.
 */
@Data
public class SalaryDetailEmailSendTO {

    @ApiModelProperty(value = "邮件模板")
    private String emailContentTemplate;

    @ApiModelProperty(value = "工资单序号")
    private String salaryDetailIds;

    @ApiModelProperty(value = "主题")
    private String subject;

    @ApiModelProperty(value = "是否回执")
    private String receiptFlag;

}
