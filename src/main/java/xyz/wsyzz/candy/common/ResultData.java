package xyz.wsyzz.candy.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import xyz.wsyzz.candy.enums.ResultEnum;

/**
 * Created by ${XC} on 2019/5/17.
 */
@Data
@ApiModel("返回包体信息")
public class ResultData {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "操作信息")
    private String msg;
    @ApiModelProperty(value = "数据包")
    private Object data;
    public ResultData(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResultData(ResultEnum resultEnum,Object data){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }
}
