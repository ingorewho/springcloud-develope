package com.ignore.mail.send.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 17:14 2018/11/16
 */
@Service
public class SendMailServiceImpl implements SendMailService{
    private Logger logger = LogManager.getLogger();
    @Override
    public void sendMail(String content) {
        test();
    }

    @Async
    protected void test(){
        logger.info("异步执行前，线程名称:" + Thread.currentThread().getName());
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("异步执行后.线程名称:" + Thread.currentThread().getName());
    }
}
