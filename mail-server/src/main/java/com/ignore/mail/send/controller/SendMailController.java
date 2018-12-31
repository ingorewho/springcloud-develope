package com.ignore.mail.send.controller;

import com.ignore.common.spring.aop.log.DbOutputLog;
import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.mail.send.service.impl.SendSimpleMailServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.slf4j.Log4jMarker;
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
@RequestMapping("/mail")
@RestController
public class SendMailController {
    @Autowired
    private SendSimpleMailServiceImpl sendSimpleMailServiceImpl;

    @PostMapping("/send/simple")
    @DbOutputLog(desc = "发生简单邮件", dbLog = true)
    public boolean sendSimpleMail(@RequestBody SimpleMailDTO mailDTO) {
        return sendSimpleMailServiceImpl.sendMail(mailDTO);
    }
}
