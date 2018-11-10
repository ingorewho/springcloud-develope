package com.ignore.spring.aop.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @Author: rzq
 * @Description:
 * 1.切面（aspect）
 * 类是对物体特征的抽象，切面就是对横切关注点的抽象
 * 2.通知（advice）
 * 通知指的就是指拦截到连接点之后要执行的代码，通知分为前置、后置、异常、最终、环绕通知五类
 * @Date: Created In 17:26 2018/8/15
 */
@Aspect
@Component
public class AspectService {
    Logger logger = LogManager.getLogger();

    /**
     * 前置:方法调用前执行
     */
    @Before("com.ignore.spring.aop.pointcut.PointCutService.point2()")
    public void before() {
    }

    /**
     * 后置:方法调用后执行，但还未退出方法
     */
    @After("com.ignore.spring.aop.pointcut.PointCutService.point3()")
    public void after() {
    }

    /**
     * 最终:退出方法后执行
     */
    @AfterReturning("com.ignore.spring.aop.pointcut.PointCutService.point4()")
    public void afterReturn() {
    }

    /**
     * 异常:发生异常时执行
     */
    @AfterThrowing("com.ignore.spring.aop.pointcut.PointCutService.point6()")
    public void afterThrowing() {
    }

    /**
     * 环绕:使用PointCutService中定义好的切点，需要写类的全限定名
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     * ProceedingJoinPoint只支持环绕通知
     */
    @Around("com.ignore.spring.aop.pointcut.PointCutService.point1()")
    public void trace(ProceedingJoinPoint point) {
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
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("类名:{},方法名:{},方法修饰:{}" , className , methodName , modifyInfo);
    }
}
