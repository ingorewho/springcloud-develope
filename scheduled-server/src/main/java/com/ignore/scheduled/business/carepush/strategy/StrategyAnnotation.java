package com.ignore.scheduled.business.carepush.strategy;

import java.lang.annotation.*;

/**
 * @Author: ignore1992
 * @Description: 策略注解
 * @Date: Created In 9:51 2019/1/30
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyAnnotation {
    /**
     * 策略类型
     * @return
     */
    StrategyEnum strategy();
}
