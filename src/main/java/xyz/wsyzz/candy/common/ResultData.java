package xyz.wsyzz.candy.common;

import lombok.Data;
import xyz.wsyzz.candy.enums.ResultEnum;

/**
 * Created by ${XC} on 2019/5/17.
 */
@Data
public class ResultData {

    private Integer code;

    private String msg;

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
