package com.ignore.spring.aop.proxy.cglibproxy;

import org.mockito.cglib.proxy.Enhancer;

import java.lang.annotation.Target;

/**
 * @Author: ignore1992
 * @Description: 生成代理对象过程:
 * 1、生成代理类Class的二进制字节码；
 * 2、通过Class.forName加载二进制字节码，生成Class对象；
 * 3、通过反射机制获取实例构造，并初始化代理类对象
 * @Date: Created In 11:40 2018/9/27
 */
public class CglibProxyHandler {
    private Object target;

    public CglibProxyHandler(Object target) {
        this.target = target;
    }

    public Object getProxyObject() {
        //Enhancer是CGLib的字节码增强器，可以方便的对类进行扩展，内部调用GeneratorStrategy.generate方法生成代理类的字节码
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibMethodInterceptor());
        return enhancer.create();
    }
}
