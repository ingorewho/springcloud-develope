package com.ignore.common.spring.properties.annotation;

import com.ignore.common.spring.properties.selector.CommonConfigPropertiesImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: renzhiqiang-lhq
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
