package com.ignore.zuul.config;

import com.ignore.zuul.extend.response.ZuulErrorAtrributes;
import com.ignore.zuul.filter.error.ErrorFilter;
import com.ignore.zuul.filter.post.PostFilter;
import com.ignore.zuul.filter.pre.PreFilter;
import com.ignore.zuul.filter.route.RouteFilter;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description： ZuulFilter配置bean
 * Author: ignore1992
 * Date: Created in 2018/11/13 21:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Configuration
public class FilterConfig {

    @Bean
    public PreFilter preFilter(){
        return new PreFilter();
    }

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }

    @Bean
    public RouteFilter routeFilter(){
        return new RouteFilter();
    }

    @Bean
    public DefaultErrorAttributes zuulErrorAtrributes(){
        return new ZuulErrorAtrributes();
    }
}
