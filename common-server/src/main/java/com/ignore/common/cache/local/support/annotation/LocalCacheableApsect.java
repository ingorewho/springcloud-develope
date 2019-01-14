package com.ignore.common.cache.local.support.annotation;

import com.ignore.common.cache.local.support.annotation.handler.LocalCacheableHandler;
import com.ignore.common.cache.local.support.annotation.wraper.CacheWraper;
import com.ignore.common.cache.local.support.annotation.wraper.CacheWraperUtils;
import com.ignore.response.cache.CacheResult;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @Author: ignore1992
 * @Description: 本地缓存注解aop处理类
 * @Date: 2019/1/13
 */
@Aspect
public class LocalCacheableApsect {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private LocalCacheableHandler localCacheableHandler;

    @Around("@annotation(localCacheable)")
    public Object localCache(ProceedingJoinPoint point, LocalCacheable localCacheable)throws Throwable{
        try {
            CacheWraper wraper = CacheWraperUtils.getCacheWraperNoResult(point);
            CacheResult cacheResult = localCacheableHandler.preHandle(wraper, localCacheable);
            Object result = cacheResult.getValue();
            if (result != null){
                logger.info("查询本地缓存成功, key={}, value={}", cacheResult.getKey(), cacheResult.getValue());
            }
            else {
                //本地缓存未命中，执行方法，然后缓存
                result = point.proceed();
                CacheWraper allWraper = CacheWraperUtils.getCacheWraperWithResult(point, result);
                cacheResult = localCacheableHandler.postHandle(allWraper, localCacheable);
                if (cacheResult.isSuccess()){
                    logger.info("添加本地缓存成功, key={}, value={}", cacheResult.getKey(), cacheResult.getValue());
                }else {
                    logger.warn("添加本地缓存失败, key={}, value={}", cacheResult.getKey(), cacheResult.getValue());
                }
            }
            return result;
        }catch (Throwable e){
            logger.error("处理本地缓存出现未知异常.", e);
            throw e;
        }
    }
}
