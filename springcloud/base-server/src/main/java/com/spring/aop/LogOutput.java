package com.spring.aop;

import java.lang.annotation.*;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 17:31 2018/8/15
 * @Modified By:
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogOutput
{
	String value() default "";
}
