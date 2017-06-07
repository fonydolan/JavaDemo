package com.dolan.common.returncode;

/**
 * @author fangqj 20170607
 */

public class ResultCode {

    private int code;

    public ResultCode(ErrorEnum errorEnum) {
        this.code = Integer.valueOf(errorEnum.getCode());
        this.msg = errorEnum.getMsg();
    }


    public ResultCode(CommonCodeEnum commonCode) {
        this.code = Integer.valueOf(commonCode.getCode());
        this.msg = commonCode.getMsg();
    }

    public ResultCode(ErrorEnum errorEnum, ModuleEnum moduleEnum) {
        this.code = Integer.valueOf(errorEnum.getCode() + moduleEnum.getCode());
        this.msg = moduleEnum.getMsg() + errorEnum.getMsg();
    }

    public ResultCode(CommonCodeEnum commonCode, String message) {
        this.code = Integer.valueOf(commonCode.getCode());
        this.msg = commonCode.getMsg() + "," + message;
    }

    public ResultCode(ErrorEnum errorEnum, String message) {
        this.code = Integer.valueOf(errorEnum.getCode());
        this.msg = errorEnum.getMsg() + "," + message;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private String msg;
}
