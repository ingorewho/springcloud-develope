package com.ignore.zuul.extend.processor;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Description： 目的是为了解决post-filter阶段的异常无法正常返回的问题，参考ZuulServlet.service()方法执行流程
 *     貌似这个问题在springcloud新版本中被修改了，因为SendErrorFilter的执行阶段由"post"改为"error"了，而且执行逻辑也优化了很多
 * Author: ignore1992
 * Date: Created in 2018/12/1 18:26
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class FailedFilterProcessor extends FilterProcessor{
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        }catch (Throwable e){
            RequestContext context = RequestContext.getCurrentContext();
            context.set("failed.filter", filter);
            throw e;
        }
    }
}
