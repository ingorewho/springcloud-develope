package com.annotation.self.service;

import java.lang.annotation.*;

/**
 * @Author: renzhiqiang-lhq
 * @Description: 注解的作用：获取到注解对应的区域，对该区域进行操作
 * @Date: Created In 14:30 2018/9/10
 * @Modified By:
 */
//以下说明的都是"元注解"，可以应用于注解的注解

//作用区域:1.Type-类、接口 2.FIELD-属性声明 3.PARAMETER-传递参数 4.CONSTRUCTOR-构造器 5.LOCAL_VARIABLE-局部变量
//	       6.ANNOTATION_TYPE-注解类型 7.PACKAGE-包注解 8.TYPE_PARAMETER-注解泛型 9.TYPE-USE-注解任意类型
@Target({ElementType.FIELD})
//存活周期:1.SOURCE:注解在编译时会被清除 2.CLASS:注释将由编译器记录在类文件中，但在运行时不需要由VM保留。这是默认行为
//         2.RUNTIME:注释将由编译器记录在类文件中，并在运行时由VM保留，因此可以反射性地读取它们。
@Retention(RetentionPolicy.RUNTIME)
//包含到javadoc中
@Documented
//注解继承:指的是当一个超类被该注解修饰时，其子类也会继承该注解
// 注：1.必须是超类，不是接口 2.如果子类被其他注解修饰，则从超类继承的注解将不会生效
@Inherited
//重复注解:后面括号中的类相当于一个容器注解(用来存放其它注解的地方)
//@Repeatable(SelfDefines.class)
public @interface SelfDefine
{
	//注解的属性:也叫做成员变量
	// 1.注解只有成员变量，没有方法
	// 2.以"无参的方法"形式来声明，其方法名定义了属性名称，返回类型定义了该成员变量的类型
	// 3.注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组
	// 4.一个注解内仅仅只有一个名字为 message 的属性时，应用这个注解时可以直接接属性值填写到括号内。
	String message() default "";

	int length();
}
