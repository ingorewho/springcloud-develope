package com.ignore.common.frame.spring.properties.annotation;

import java.lang.annotation.*;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:17 2018/12/5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CommonConfigProperties {
    String prefix() default "";
}
