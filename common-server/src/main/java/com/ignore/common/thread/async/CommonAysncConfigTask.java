package com.ignore.common.thread.async;

import com.ignore.common.thread.async.config.impl.AsyncThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:37 2018/11/16
 */
@Configuration
@EnableAutoConfiguration
@EnableAsync
public class CommonAysncConfigTask {
    @Value("${thread.pool.corePoolSize:5}")
    private int corePoolSize;
    @Value("${thread.pool.maxPoolSize:10}")
    private int maxPoolSize;
    @Value("${thread.pool.keepAliveTime:10}")
    private int keepAliveTime;
    @Value("${thread.pool.queueCapcity:10}")
    private int queueCapcity;

    @Autowired
    private AsyncThreadPoolConfig asyncThreadPoolConfig;

    @Bean("commonThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        return asyncThreadPoolConfig.getThreadPoolTaskExecutor(corePoolSize , maxPoolSize , keepAliveTime , queueCapcity);
    }
}
