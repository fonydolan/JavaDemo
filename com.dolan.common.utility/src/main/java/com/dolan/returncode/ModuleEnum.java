package com.dolan.common.returncode;

/**
 * @author fangqj 20170607
 */
//0成功， 错误格式为 错误级别1位+模块类型3位+具体错误3位
public enum ModuleEnum {
    UID("001", "UID"),
    MOBILE("002", "手机"),
    USER("003","用户"),
    EMAIL("004", "邮箱"),
    PASSWORD("005", "密码"),
    PASSWORD_TYPE("006", "密码类型"),
    
    LOG("099", "日志");

    private String code;
    private String msg;

    ModuleEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
