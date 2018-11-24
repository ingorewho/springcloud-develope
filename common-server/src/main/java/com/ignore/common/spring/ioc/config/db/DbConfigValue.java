package com.ignore.common.spring.ioc.config.db;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DbConfigValue {
    /**
     * 配置key值
     * @return
     */
    String key();

    /**
     * 是否必需
     * @return
     */
    boolean required() default false;
}
