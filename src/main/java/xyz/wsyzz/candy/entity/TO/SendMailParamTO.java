package xyz.wsyzz.candy.entity.TO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by xucan on 2022/2/26.
 */
@Data
@ApiModel("发送邮件入参")
public class SendMailParamTO {

    @ApiModelProperty(value = "主题")
    private String subject;
    @ApiModelProperty(value = "发送到的邮箱")
    private List<String> toMailAddressList;
    @ApiModelProperty(value = "邮件内容")
    private String content;
    @ApiModelProperty(value = "邮件内容类型")
    private String contentType;
    @ApiModelProperty(value = "是否回执")
    private String receiptFlag;
    @ApiModelProperty(value = "抄送列表")
    private List<String> addressList;
    @ApiModelProperty(value = "附件地址")
    private String enclosurePath;
}
