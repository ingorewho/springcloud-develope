package com.json.test;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:29 2018/9/21
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b instanceof B);
    }
}

abstract class A {

}

class B extends A {

}
