package com.ignore.async.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author: ignore1992
 * @Description: 获取SpringBoot异步线程池接口
 * @Date: Created In 15:24 2018/11/16
 */
public interface AsyncConfig {

    /**
     * 获取SpringBoot异步线程池
     *
     * @return
     */
    ThreadPoolTaskExecutor getThreadPoolTaskExecutor(int corePoolSize , int maxPoolSize , int keepAliveTime , int queueCapacity);
}
