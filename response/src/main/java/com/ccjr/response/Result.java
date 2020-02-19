
package com.ccjr.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author ling
 */
@Getter
@Setter
public class Result implements Serializable {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 服务器当前timestamp
     */
    private Long timestamp = System.currentTimeMillis();
    /**
     * 成功时返回的数据
     */
    private Object data;
    /**
     *失败时返回的错误码
     */
    private int errCode;
    /**
     *失败时返回的错误码
     */
    private String errMsg;
    public static Result ofSuccess(Object data){
        Result result = new Result();
        result.success = true;
        result.data = data;
        return result;
    }

    public static Result ofFail(ErrInfoInterface errInfoInterface){
        return ofFail(errInfoInterface, errInfoInterface.getErrMsg());
    }

    /**
     * 符合该错误码的错误提供可自定义的提示信息
     * @param errInfoInterface 错误码
     * @param errorMsg 错误信息
     * @return 错误结果
     */
    public static Result ofFail(ErrInfoInterface errInfoInterface, String errorMsg){
        Result result = new Result();
        result.success=false;
        result.setErrCode(errInfoInterface.getErrCode());
        result.setErrMsg(errorMsg);
        return result;
    }

}