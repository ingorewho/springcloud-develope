package com.ignore.zuul.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import sun.misc.Request;

import javax.servlet.http.HttpServletResponse;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/24 14:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class ErrorFilter extends ZuulFilter {
    private Logger logger = LogManager.getLogger();
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable e = context.getThrowable();
        if (e != null){
            logger.error("执行ErrorFilter，打印异常:{}", e.getMessage());
        }
        return null;
    }
}
