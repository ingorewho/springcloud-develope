package com.ignore.common.cache.local.support.interceptor.generator;

import java.lang.reflect.Method;

/**
 * @Author: ignore1992
 * @Description: 默认key生成器
 * @Date: 2019/1/13
 */
public class DefaultLocalCacheKeyGenerator extends AbstractLocalCacheKeyGenerator{
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return null;
    }
}
