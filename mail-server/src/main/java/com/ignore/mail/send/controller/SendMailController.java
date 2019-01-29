package com.ignore.mail.send.controller;

import com.ignore.common.frame.spring.aop.log.OutputLog;
import com.ignore.dto.mail.AttachMailDTO;
import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.mail.send.service.impl.SendAttachMailServiceImpl;
import com.ignore.mail.send.service.impl.SendSimpleMailServiceImpl;
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
@RestController
public class SendMailController {
    @Autowired
    private SendSimpleMailServiceImpl sendSimpleMailService;
    @Autowired
    private SendAttachMailServiceImpl sendAttachMailService;
    @PostMapping("/send/simple")
    @OutputLog(desc = "发生简单邮件")
    public boolean sendSimpleMail(@RequestBody SimpleMailDTO mailDTO) {
        return sendSimpleMailService.sendMail(mailDTO);
    }

    @PostMapping("/send/attach")
    @OutputLog(desc = "发生简单邮件")
    public boolean sendAttachMail(@RequestBody AttachMailDTO mailDTO) {
        return sendAttachMailService.sendMail(mailDTO);
    }
}
