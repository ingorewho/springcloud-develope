package com.ignore.common.cache.local.support.interceptor.generator;

import org.aspectj.lang.Signature;

import java.lang.reflect.Method;

/**
 * @Author: renzhiqiang-lhq
 * @Description: 缓存key生成接口
 * @Date: Created In 15:41 2019/1/14
 */
public interface CacheKeyGenerator {
    Object generate(Object target, Signature signature, Object... params);
}
