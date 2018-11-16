package com.spring.aop.proxy.jdkproxy;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:52 2018/9/27
 * @Modified By:
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        JDKProxyHandler handler = new JDKProxyHandler(new JDKServiceImpl());
        JDKProxyService proxyService = (JDKProxyService) handler.getProxyObject();
        proxyService.jdkMethod();
    }

}
