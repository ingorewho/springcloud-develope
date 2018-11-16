package com.ignore.async;

import com.ignore.async.config.impl.AsyncThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

import java.util.concurrent.Executor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:05 2018/11/16
 */
@Configuration
@EnableAutoConfiguration
@EnableAsync
public class AsyncConfigService extends AsyncConfigurerSupport {
    @Value("${thread.pool.corePoolSize:5}")
    private int corePoolSize;
    @Value("${thread.pool.maxPoolSize:10}")
    private int maxPoolSize;
    @Value("${thread.pool.keepAliveTime:10}")
    private int keepAliveTime;
    /**
     * 默认为0，每次创建新线程
     */
    @Value("${thread.pool.queueCapcity:0}")
    private int queueCapcity;

    @Autowired
    private AsyncThreadPoolConfig asyncThreadPoolConfig;

    @Bean
    @Override
    public Executor getAsyncExecutor() {
        return asyncThreadPoolConfig.getThreadPoolTaskExecutor(corePoolSize , maxPoolSize , keepAliveTime , queueCapcity);
    }
}
