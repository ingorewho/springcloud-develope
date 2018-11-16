package com.ignore.annotation.self.service;

import java.lang.annotation.*;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:18 2018/9/11
 * @Modified By:
 */
@Target(ElementType.TYPE_USE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ParentDefine {
}
