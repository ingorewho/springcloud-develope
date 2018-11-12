package com.ignore.utils.aop.aspect.log.trace;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * Description： 切面扫描打印trac日志
 * Author: ignore1992
 * Date: Created in 2018/11/10 15:10
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Aspect
@Component
public class TraceLogAspectHandler {
    private Logger logger = LogManager.getLogger();

    @Pointcut("execution(* com.ignore.*..*.*(..))")
    public void logPoint(){

    }

    @Around("logPoint()")
    public void trace(ProceedingJoinPoint point){
        //获取方法实例
        Signature signature = point.getSignature();
        //获取调用方法全名称:包名.类名.方法名
        String caller = signature.toLongString();
        //获取类名
        String className = signature.getDeclaringTypeName();
        //获取方法名
        String methodName = signature.getName();
        //获取方法修饰
        String modifyInfo = Modifier.toString(signature.getModifiers());
        //参数
        Object[] args = point.getArgs();
        long start = System.currentTimeMillis();
        try {
            point.proceed();
            logger.trace("类名:{},调用方法名:{},参数:{},耗时:{}" , className , methodName , args, System.currentTimeMillis() - start);
        } catch (Throwable throwable) {
            logger.error(throwable);
        }
    }

}
