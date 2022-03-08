package xyz.wsyzz.candy.entity.TO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by xucan on 2022/2/26.
 */
@Data
@ApiModel("发送邮件入参")
public class SendMailParamTO {

    @ApiModelProperty(value = "发送到的邮箱")
   private String toMailAddress;
    @ApiModelProperty(value = "邮件内容")
    private String content;

}
