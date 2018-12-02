package com.ignore.zuul.extend.refresh;

import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.Map;
import java.util.Properties;

/**
 * Description： 实现动态加载本地application配置文件
 * Author: ignore1992
 * Date: Created in 2018/12/2 18:01
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class LocalDynamicRefreshableRouteLocator extends DynamicRefreshableRouteLocator{
    public LocalDynamicRefreshableRouteLocator(String servletPath, ZuulProperties properties){
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> loadLocalRoutes() {
        Properties applicationProperties = new Properties();
        return null;
    }
}
