package com.ignore.common.thread.async.config.impl;

import com.ignore.common.thread.async.config.AsyncConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:27 2018/11/16
 */
@Component("asyncThreadPoolConfig")
public class AsyncThreadPoolConfig implements AsyncConfig {

    @Override
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(int corePoolSize , int maxPoolSize , int keepAliveTime , int queueCapacity) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        executor.setRejectedExecutionHandler(new LoggerPolicy());
        return executor;
    }

    public static class LoggerPolicy implements RejectedExecutionHandler{
        private Logger logger = LogManager.getLogger();
        public LoggerPolicy(){
        }

        @Override
        public void rejectedExecution(Runnable r , ThreadPoolExecutor executor) {
            logger.warn("线程池任务已满，进入拒绝策略!");
        }
    }
}
