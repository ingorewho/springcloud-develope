package com.ignore.common.thread.common;

import com.ignore.common.thread.strategy.ThreadRejectLogHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;

/**
 * @Author: ignore1992
 * @Description: 继承AsyncConfigurerSupport，实现对@Aysnc默认的
 * @Date: Created In 16:38 2018/11/16
 */
@Configuration
@EnableAutoConfiguration
public class CommonAsyncConfigExecutor {
    @Value("${thread.pool.corePoolSize:5}")
    private int corePoolSize;
    @Value("${thread.pool.maxPoolSize:10}")
    private int maxPoolSize;
    @Value("${thread.pool.keepAliveTime:10}")
    private int keepAliveTime;
    @Value("${thread.pool.queuSize:1024}")
    private int queueSize;
    /**
     * 默认为10.
     */
    @Value("${thread.pool.queueCapcity:10}")
    private int queueCapcity;

    @Bean("commonExecutorService")
    public ExecutorService getExecutorService() {
        CommonThreadExecutor executor = new CommonThreadExecutor(corePoolSize , maxPoolSize , queueSize, keepAliveTime , "common");
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadRejectLogHandler());
        return executor;
    }
}
