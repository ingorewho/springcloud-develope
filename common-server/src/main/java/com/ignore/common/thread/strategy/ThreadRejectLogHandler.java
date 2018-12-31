package com.ignore.common.thread.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/31 15:41
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class ThreadRejectLogHandler implements RejectedExecutionHandler{
    private Logger logger = LogManager.getLogger();

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //任务执行不过来，就打印一个warn日志
        logger.warn("线程池队列已满，进入拒绝策略..");
    }
}
