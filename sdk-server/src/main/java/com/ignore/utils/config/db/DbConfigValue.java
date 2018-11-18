package com.ignore.utils.config.db;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DbConfigValue {
    /**
     * 
     * @return
     */
    String value();

}
