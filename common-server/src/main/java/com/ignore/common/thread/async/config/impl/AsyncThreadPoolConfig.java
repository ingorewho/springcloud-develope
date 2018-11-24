package com.ignore.common.thread.async.config.impl;

import com.ignore.common.thread.async.config.AsyncConfig;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

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
        return executor;
    }
}
