package com.ignore.common.spring.properties.annotation;

import java.lang.annotation.*;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 17:17 2018/12/5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CommonConfigProperties {
    String prefix() default "";
}
