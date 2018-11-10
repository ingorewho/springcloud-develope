package com.ignore.spring.aop.proxy.cglibproxy;

import org.mockito.cglib.proxy.Enhancer;

/**
 * @Author: renzhiqiang-lhq
 * @Description:

 *
 * @Date: Created In 11:29 2018/9/27
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        CglibProxyHandler handler = new CglibProxyHandler(new CglibProxyService());
        CglibProxyService proxyService = (CglibProxyService) handler.getProxyObject();
        proxyService.cglibMethod();
        proxyService.cglibMethodProtect();
    }
}
