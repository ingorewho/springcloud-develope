package com.ignore.zuul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/2 17:24
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Configuration
public class ZuulRefreshConfig {
    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
