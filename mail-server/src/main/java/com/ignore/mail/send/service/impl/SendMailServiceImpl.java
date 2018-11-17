package com.ignore.mail.send.service.impl;

import com.ignore.mail.send.service.SendMailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:14 2018/11/16
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private SendTestService sendTestService;

    @Override
    public void sendMail(String content) {
        sendTestService.test();
    }


}
