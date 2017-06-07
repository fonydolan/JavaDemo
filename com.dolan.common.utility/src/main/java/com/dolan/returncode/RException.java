package com.dolan.common.returncode;

/**
 * @author fangqj 20170607
 */
public class RException extends Exception {

    private final ResultCode returnCode;

    public RException(ResultCode returnCode) {
        this.returnCode = returnCode;
    }

    public RException(CommonCodeEnum commonCode, String message) {
        this.returnCode = new ResultCode(commonCode, message);
    }

    public RException(ErrorEnum errorEnum, ModuleEnum moduleEnum) {
        this.returnCode = new ResultCode(errorEnum, moduleEnum);
    }

    public RException(ErrorEnum errorEnum, String message) {
        this.returnCode = new ResultCode(errorEnum, message);
    }

    public RException(RException e) {
        this.returnCode = e.returnCode;
    }

    public RException(CommonCodeEnum common800) {
        this.returnCode = new ResultCode(common800);
    }

    public RException(ErrorEnum errorEnum) {
        this.returnCode = new ResultCode(errorEnum);
    }

    public int getErrorCode() {
        return this.returnCode.getCode();
    }

    public String getErrorMsg() {
        return this.returnCode.getMsg();
    }
}
