package com.ignore.mail.send.service.impl;

import com.ignore.mail.send.service.SendMailService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    private Logger logger = LogManager.getLogger();

    @Autowired
    private SendTestService sendTestService;

    @HystrixCommand(fallbackMethod = "fail")
    @Override
    public void sendMail(String content) {
        sendTestService.test();
    }

    private void fail(){
        logger.error("发送邮件失败!");
    }
}
