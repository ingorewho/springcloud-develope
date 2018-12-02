package com.ignore.zuul.extend.refresh;

import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/2 17:49
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public abstract class DynamicRefreshableRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public DynamicRefreshableRouteLocator(String servletPath, ZuulProperties properties){
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        return loadLocalRoutes();
    }

    /**
     * 获取配置(子类实现)
     * @return
     */
    protected abstract Map<String, ZuulProperties.ZuulRoute> loadLocalRoutes();

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
