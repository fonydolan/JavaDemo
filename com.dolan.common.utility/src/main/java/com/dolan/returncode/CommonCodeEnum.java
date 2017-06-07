package com.dolan.common.returncode;

/**
 * 
 * @author fangqj 20170607
 *
 */
public enum CommonCodeEnum {
    SUCCESS("0", "成功"),
    REQUEST_TOOMUCH("429", "访问过于频繁"),
    REQUEST_METHODERROR("450", "请求方式限制(GET/POST/HTTPS)"),
    ACCOUNT_NORIGHT("500", "权限不足"),
    ACCOUNT_CANCELED("800","账号已注销"),
    ACCOUNT_FROZEN("801", "账号被冻结"),
    SYS_ERROR("900", "服务内部错误");

    private String code;
    private String msg;

    CommonCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public int getIntCode() {
        return Integer.parseInt(code);
    }

    public String getMsg() {
        return msg;
    }


}