package com.jdk1_8.default_method;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 18:05 2018/9/5
 * @Modified By:
 */
public interface DefaultMethodInterface
{
	/**
	 * 非静态方法用default修饰
	 * @param arg
	 */
	default void defaultMethod1(String arg)
	{
		System.out.println(arg);
	}

	/**
	 * 静态方法不需要用deafult修饰
	 * @param arg
	 */
	static void defaultMethod2(String arg)
	{
		System.out.println(arg);
	}

	public void test();
}
