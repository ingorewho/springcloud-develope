package com.ignore.utils.aop.aspect.log;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DbOutputLog {

    /**
     * 日志类型
     *
     * @return
     */
    String desc();

    /**
     * 是否写db
     *
     * @return
     */
    boolean dbLog() default false;
}
