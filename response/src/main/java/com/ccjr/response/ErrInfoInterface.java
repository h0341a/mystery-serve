package com.ccjr.response;

/**
 * @author ling
 */
public interface ErrInfoInterface {

    /**
     * 获取错误码
     * @return 错误码
     */
    public int getErrCode();

    /**
     * 获取错误信息
     * @return msg
     */
    public String getErrMsg();

    /**
     * 设置自定义的提示信息
     * @param customMsg 自定义信息
     * @return 当前错误码对象
     */
    public ErrInfoInterface setErrMsg(String customMsg);


}
