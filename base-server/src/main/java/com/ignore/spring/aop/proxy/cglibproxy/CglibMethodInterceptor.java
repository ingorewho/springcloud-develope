package com.ignore.spring.aop.proxy.cglibproxy;

import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:27 2018/9/27
 * @Modified By:
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o , Method method , Object[] objects , MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib开始调用代理方法..");
        //注意:这里是调用invokeSuper方法，即调用父类方法，不能调用invoke方法，调用当前方法进入了死循环，会导致栈溢出
        Object result = methodProxy.invokeSuper(o , objects);
        System.out.println("cglib结束调用代理方法..");
        return result;
    }
}
