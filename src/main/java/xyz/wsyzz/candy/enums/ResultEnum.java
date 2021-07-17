package xyz.wsyzz.candy.enums;

/**
 * Created by ${XC} on 2019/5/17.
 */
public enum ResultEnum {

    SUCCESS(200,"操作成功!"),

    RESOURCE_NOT_FOUND(404,"找不到相关资源!"),

    USERNAME_NOT_FOUND(501,"用户名不存在!"),

    VERIFICATION_CODE_FAILURE(503,"验证码失效!"),

    WRONG_PASSSWORD(502,"密码错误!"),

    ERROR(500,"内部错误!");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
