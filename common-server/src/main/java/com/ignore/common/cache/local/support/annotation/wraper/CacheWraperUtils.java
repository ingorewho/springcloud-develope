package com.ignore.common.cache.local.support.annotation.wraper;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:02 2019/1/14
 */
public class CacheWraperUtils {
    public static CacheWraper getCacheWraperEmpty(){
        return new CacheWraper();
    }

    public static CacheWraper getCacheWraperNoResult(ProceedingJoinPoint point){
        return new CacheWraper(point.getTarget(), point.getSignature(),point.getArgs(), null);
    }

    public static CacheWraper getCacheWraperWithResult(ProceedingJoinPoint point, Object result){
        return new CacheWraper(point.getTarget(), point.getSignature(),point.getArgs(), result);
    }
}
