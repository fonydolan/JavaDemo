package com.dolan.common.returncode;

/**
 * Created by dingyr on 2017/2/13.
 */
public enum ErrorEnum {
    FAIL("001", "失败"),
    ERROR("002", "异常"),
    COMMON_400("400", "参数不合法(配置/数量)"),
    COMMON_410("410", "参数格式错误"),
    COMMON_420("420", "参数为空"),
    COMMON_430("430", "参数超过限制"),
    COMMON_440("440", "参数缺少"),
    COMMON_510("510", "参数超时或已过期"),
    COMMON_520("520", "参数不存在"),
    COMMON_530("530", "参数不合法(验证不合法)"),
    COMMON_540("540", "数据已存在"),
    COMMON_550("550", "数据不存在");

    private String code;
    private String msg;

    ErrorEnum(String code, String msg) {
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