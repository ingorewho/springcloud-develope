package com.ignore.mail.send.service;

import com.ignore.dto.mail.MailDTO;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:14 2018/11/16
 */
public interface SendMailService<T>{
    boolean sendMail(T mailDTO);
}
