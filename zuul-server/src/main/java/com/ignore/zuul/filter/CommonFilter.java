package com.ignore.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Description： 公共过滤器
 * Author: ignore1992
 * Date: Created in 2018/11/13 20:58
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class CommonFilter  extends ZuulFilter{
    private Logger logger = LogManager.getLogger();
    @Override
    public String filterType() {
        //pre表示在路由之前进行过滤
        return "pre";
    }

    @Override
    public int filterOrder() {
        //在同一生命周期内有多个过滤器，需要根据该值来确定执行顺序
        //值越大，优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //为true时执行过滤操作
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info("当前请求url:{}", request.getRequestURI());
        String accessToken = request.getParameter("token");
        if (StringUtils.isBlank(accessToken)){
            logger.warn("token为空!");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        logger.info("access sucessfully!");
        return null;
    }
}
