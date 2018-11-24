package com.ignore.zuul.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/24 14:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //error: 处理请求时发生错误时被调用。
        return "error";
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