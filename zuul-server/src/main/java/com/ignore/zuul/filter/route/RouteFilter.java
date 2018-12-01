package com.ignore.zuul.filter.route;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/24 14:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class RouteFilter extends ZuulFilter{
    @Override
    public String filterType() {
        //routing: 在路由请求时被调用。
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
