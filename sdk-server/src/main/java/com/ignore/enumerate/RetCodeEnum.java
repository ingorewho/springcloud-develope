package com.ignore.enumerate;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:26 2018/12/17
 */
public enum RetCodeEnum {
    SUCCESS("1", "接口返回成功!"),
    CONNECT_TIME_OUT_CODE("-100", "连接超时");

    private String errorCode;
    private String description;

    private RetCodeEnum(String errorCode, String description){
        this.errorCode = errorCode;
        this.description =description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
