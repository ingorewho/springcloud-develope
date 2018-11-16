package com.ignore.spring.aop.proxy.cglibproxy;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:05 2018/9/27
 */
public class CglibProxyService {
    public void cglibMethod() {
        System.out.println("cglib public..");
    }

    protected void cglibMethodProtect() {
        System.out.println("cglib protected..");
    }

    private void cglibMethodPrivate() {
        System.out.println("cglib private..");
    }
}
