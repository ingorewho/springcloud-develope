package com.ignore.common.cache.local.support.annotation.wraper;

import javafx.beans.binding.ObjectExpression;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.Signature;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 15:56 2019/1/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheWraper {
    /**执行对象**/
    private Object target;
    /**方法对象**/
    private Signature signature;
    /**参数数组**/
    private Object[] params;
    /**缓存结果**/
    private Object result;
}