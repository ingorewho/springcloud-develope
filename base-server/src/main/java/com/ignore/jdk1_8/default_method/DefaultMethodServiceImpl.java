package com.jdk1_8.default_method;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:08 2018/9/5
 * @Modified By:
 */
public class DefaultMethodServiceImpl implements DefaultMethodInterface {
    @Override
    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        DefaultMethodInterface instance = new DefaultMethodServiceImpl();
        instance.defaultMethod1("test");
        DefaultMethodInterface.defaultMethod2("test");
        instance.test();
    }
}
