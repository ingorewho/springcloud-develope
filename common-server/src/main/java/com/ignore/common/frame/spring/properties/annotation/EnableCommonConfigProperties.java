package com.ignore.common.frame.spring.properties.annotation;

import com.ignore.common.frame.spring.properties.selector.CommonConfigPropertiesImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:21 2018/12/5
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CommonConfigPropertiesImportSelector.class)
public @interface EnableCommonConfigProperties {
    /**
     * 启用ccmmon配置的类
     * @return
     */
    Class<?>[] classes() default {};
}
