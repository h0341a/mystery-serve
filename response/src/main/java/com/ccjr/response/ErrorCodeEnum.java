package com.ccjr.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ling
 */
public enum ErrorCodeEnum implements ErrInfoInterface {
    /**
     * 错误码
     */
    UNKNOWN_ERROR(1, "未知错误"),
    USER_NOT_LOGIN(300, "用户未登录"),
    PARAMETER_INVALID(400, "参数不合法")
    ;
    private int errCode;
    private String errMsg;

    ErrorCodeEnum(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public ErrInfoInterface setErrMsg(String customMsg) {
        this.errMsg = customMsg;
        return this;
    }
}
