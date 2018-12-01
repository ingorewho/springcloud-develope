package com.ignore.zuul.extend.response;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * Description： 自定义zuul错误返回结果
 * Author: ignore1992
 * Date: Created in 2018/12/1 23:28
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class ZuulErrorAtrributes extends DefaultErrorAttributes{
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean b) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, b);
        errorAttributes.put("sorry", "请再试一次！");
        return errorAttributes;
    }

    @Override
    public Throwable getError(RequestAttributes requestAttributes) {
        return super.getError(requestAttributes);
    }
}
