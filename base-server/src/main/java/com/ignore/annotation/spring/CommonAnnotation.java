package com.ignore.annotation.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:39 2018/12/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CommonImportSelelctor.class)
public @interface CommonAnnotation {
    String value()default "";
}
