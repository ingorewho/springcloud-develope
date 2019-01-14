package com.ignore.common.cache.local.support.annotation.handler;

import com.ignore.common.cache.local.service.LocalCacheService;
import com.ignore.common.cache.local.service.impl.AbstractLocalCacheService;
import com.ignore.common.cache.local.service.impl.DefaultCacheService;
import com.ignore.common.cache.local.service.impl.SafeMapCacheService;
import com.ignore.common.cache.local.support.annotation.LocalCacheable;
import com.ignore.common.cache.local.support.annotation.wraper.CacheWraper;
import com.ignore.common.cache.local.support.interceptor.generator.CacheKeyGenerator;
import com.ignore.common.cache.local.support.strategy.LocalCacheableStrategy;
import com.ignore.common.cache.local.support.strategy.impl.SafeMapCacheStrategy;
import com.ignore.common.frame.spring.ioc.CommonContextAware;
import com.ignore.response.cache.CacheResult;
import com.ignore.response.cache.CacheValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: LocalCacheable注解处理器
 * @Date: 2019/1/13
 */
@Component
public class LocalCacheableHandler{
    @Autowired
    private CommonContextAware commonContextAware;

    /**
     * 前置操作，主要用于get缓存
     * @param wraper
     * @param localCacheable
     * @return
     */
    public CacheResult preHandle(CacheWraper wraper, LocalCacheable localCacheable){
        LocalCacheableStrategy strategy = getCacheableStrategy(localCacheable);
        CacheKeyGenerator keyGenerator = strategy.getKeyGenerator(localCacheable);
        String key = localCacheable.key();
        if (keyGenerator != null){
            key = keyGenerator.generate(wraper.getTarget(), wraper.getSignature(),wraper.getParams()).toString();
        }
        Class beanClazz = getCacheServiceClass(localCacheable);
        LocalCacheService localCacheService = (LocalCacheService)commonContextAware.getSelfApplicationContext().getBean(beanClazz);
        return localCacheService.get(key);
    }

    /**
     * 后置操作，主要用于更新缓存
     * @param wraper
     * @param localCacheable
     * @return
     */
    public CacheResult postHandle(CacheWraper wraper, LocalCacheable localCacheable){
        LocalCacheableStrategy strategy = getCacheableStrategy(localCacheable);
        CacheKeyGenerator keyGenerator = strategy.getKeyGenerator(localCacheable);
        String key = localCacheable.key();
        if (keyGenerator != null){
            key = keyGenerator.generate(wraper.getTarget(), wraper.getSignature(),wraper.getParams()).toString();
        }
        Class beanClazz = getCacheServiceClass(localCacheable);
        LocalCacheService localCacheService = (LocalCacheService)commonContextAware.getSelfApplicationContext().getBean(beanClazz);
        return localCacheService.put(key, wraper.getResult(), localCacheable.expireInterval());
    }

    private LocalCacheableStrategy getCacheableStrategy(LocalCacheable localCacheable){
        switch (localCacheable.type()){
            case SAFE_MAP:
                return new SafeMapCacheStrategy();
            default:
                return new SafeMapCacheStrategy();
        }
    }

    private Class<? extends AbstractLocalCacheService> getCacheServiceClass(LocalCacheable localCacheable){
        switch (localCacheable.value()){
            case SAFE_MAP:
                return SafeMapCacheService.class;
            default:
                return DefaultCacheService.class;
        }
    }

}
