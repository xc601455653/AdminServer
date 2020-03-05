package xyz.wsyzz.candy.util;

import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.enums.ResultEnum;

/**
 * Created by ${XC} on 2019/5/17.
 */
public class ResultDataUtils {

    public static ResultData success(Object data){
        return new ResultData(ResultEnum.SUCCESS,data);
    }
    public static ResultData success(){
        return new ResultData(ResultEnum.SUCCESS,null);
    }
    public static ResultData failure(){
        return new ResultData(ResultEnum.ERROR,null);
    }
    public static ResultData exception(String msg){
        return new ResultData(ResultEnum.ERROR.getCode(),msg,null);
    }
}
