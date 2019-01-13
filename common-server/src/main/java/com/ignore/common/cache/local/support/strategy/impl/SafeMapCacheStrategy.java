package com.ignore.common.cache.local.support.strategy.impl;

import com.ignore.common.cache.local.support.annotation.LocalCacheable;
import com.ignore.common.cache.local.support.interceptor.generator.DefaultLocalCacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.generator.SimpleLocalCacheKeyGenerator;
import com.ignore.common.cache.local.support.strategy.LocalCacheableStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.interceptor.KeyGenerator;

/**
 * @Author: ignore1992
 * @Description: 安全map缓存策略
 * @Date: 2019/1/13
 */
public class SafeMapCacheStrategy implements LocalCacheableStrategy{

    @Override
    public KeyGenerator getKeyGenerator(LocalCacheable localCacheable) {
        if (StringUtils.isNotBlank(localCacheable.key())){
            //指定了key值则不使用key生成器
            return null;
        }

        switch (localCacheable.keyGenerator()){
            case SIMPLE:
                return new SimpleLocalCacheKeyGenerator();
            default:
                return new DefaultLocalCacheKeyGenerator();
        }
    }
}
