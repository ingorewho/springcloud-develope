package com.ignore.common.cache.local.support.annotation.wraper;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:02 2019/1/14
 */
public class CacheKeyUtils {
    public static CacheKey getCacheWraperEmpty(){
        return new CacheKey();
    }

    public static CacheKey getCacheWraperNoResult(ProceedingJoinPoint point){
        return new CacheKey(point.getTarget(), point.getSignature(),point.getArgs(), null);
    }

    public static CacheKey getCacheWraperWithResult(ProceedingJoinPoint point, Object result){
        return new CacheKey(point.getTarget(), point.getSignature(),point.getArgs(), result);
    }
}
