package com.ignore.mail.send.controller;

import com.ignore.mail.send.service.impl.SendMailServiceImpl;
import com.ignore.utils.aop.log.DbOutputLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description： 发送邮件controller
 * Author: ignore1992
 * Date: Created in 2018/11/10 15:37
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@RequestMapping(value = "/mail")
@RestController
public class SendMailController {
    @Autowired
    private SendMailServiceImpl sendMailServiceImpl;


    @PostMapping("/send/simple")
    @DbOutputLog(desc = "发生简单邮件", dbLog = true)
    public String sendSimpleMail(@RequestBody String data) {
        sendMailServiceImpl.sendMail(data);
        return "发生简单邮件成功!";
    }
}
