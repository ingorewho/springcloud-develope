package com.ignore.exception.mail;

import com.ignore.enumerate.ExceptionEnum;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:20
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class MailException extends RuntimeException{
    private String msg;
    private ExceptionEnum exception;

    public MailException(){

    }

    public MailException(String msg, ExceptionEnum exception){
        this.msg = msg;
        this.exception = exception;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExceptionEnum getException() {
        return exception;
    }

    public void setException(ExceptionEnum exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "MailException{" +
                "msg='" + msg + '\'' +
                ", exception=" + exception +
                '}';
    }
}
