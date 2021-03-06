package com.ignore.exception.mail;

import com.ignore.enumerate.ExceptionEnum;
import com.thoughtworks.xstream.core.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:20
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class MailException extends RuntimeException{
    private String msg;
    private ExceptionEnum exception;
}
