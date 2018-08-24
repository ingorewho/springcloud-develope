package com.spring.aop;

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
 * @Author: rzq
 * @Description:
 * @Date: Created In 17:26 2018/8/15
 * @Modified By:
 */
@Aspect
@Component
public class BaseBizAspect
{
	Logger logger = LogManager.getLogger();

	@Pointcut("execution(* com.spring.*..*.*(..))")
	public void pointCut()
	{

	}

	@Around("@annotation(output)")
	public void log(ProceedingJoinPoint point, LogOutput output)
	{
		//获取方法实例
		Signature signature = point.getSignature();
		//获取类名
		String className = signature.getDeclaringTypeName();
		//获取方法名
		String methodName = signature.getName();
		//获取方法修饰
		String modifyInfo = Modifier.toString(signature.getModifiers());
		try
		{
			point.proceed();
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();
		}
		logger.info("类名:{},方法名:{},方法修饰:{}", className, methodName, modifyInfo);
	}
}
