package com.spring.aop.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:49 2018/9/27
 * @Modified By:
 */
public class JDKProxyHandler implements InvocationHandler {
    private Object target;

    public JDKProxyHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy , Method method , Object[] args) throws Throwable {
        System.out.println("开始调用代理方法..");
        Object result = method.invoke(target , args);
        System.out.println("结束调用代理方法..");
        return result;
    }

    public Object getProxyObject() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader() , target.getClass().getInterfaces() , this);
    }
}
