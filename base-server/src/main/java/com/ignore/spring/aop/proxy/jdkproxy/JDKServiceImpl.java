package com.spring.aop.proxy.jdkproxy;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 10:48 2018/9/27
 * @Modified By:
 */
public class JDKServiceImpl  implements  JDKProxyService{
    @Override
    public void jdkMethod() {
        System.out.println("jdk..");
    }

    private void jdkPrivate()
    {
        System.out.println("jdk private..");
    }
}
