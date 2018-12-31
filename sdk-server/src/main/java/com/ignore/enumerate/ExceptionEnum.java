package com.ignore.enumerate;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:21
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public enum  ExceptionEnum {
    MAIL_SEND_ERROR(001, "发生邮件失败!");

    private int code;
    private String desc;

    private ExceptionEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ExceptionEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
