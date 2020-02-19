package com.ccjr.response;

import lombok.Getter;

/**
 * @author ling
 */
@Getter
public class BusinessException extends Exception {

    public ErrInfoInterface errInfo;

    public BusinessException() {
        super();
    }

    public BusinessException(ErrInfoInterface errInfo) {
        this.errInfo = errInfo;
    }

    public BusinessException(ErrInfoInterface errInfo, String customMsg){
        this.errInfo = errInfo.setErrMsg(customMsg);
    }

}
