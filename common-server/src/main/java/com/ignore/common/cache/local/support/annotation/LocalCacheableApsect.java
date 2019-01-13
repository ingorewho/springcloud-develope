package com.ignore.common.cache.local.support.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author: ignore1992
 * @Description: 本地缓存注解aop处理类
 * @Date: 2019/1/13
 */
@Aspect
public class LocalCacheableApsect {

    @Around("@annotation(localCacheable)")
    public Object localCache(ProceedingJoinPoint point, LocalCacheable localCacheable){
        //执行对象
        Object target = point.getTarget();
        //方法
        Signature signature = point.getSignature();
        //参数
        Object[] args = point.getArgs();

        try {

        }catch (Exception e){

        }
    }

}
