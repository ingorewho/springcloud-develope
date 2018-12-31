package com.ignore.common.thread.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/31 15:54
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class ThreadAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler{
    private Logger logger = LogManager.getLogger();

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        logger.warn("异步执行过程中出现未知异常:{}，方法:{}，参数:{}", throwable.getMessage(), method.getName(), objects);
    }
}
