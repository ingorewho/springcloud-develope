package com.ignore.mail.send.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/16 20:25
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class SendTestService {
    private Logger logger = LogManager.getLogger();

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
