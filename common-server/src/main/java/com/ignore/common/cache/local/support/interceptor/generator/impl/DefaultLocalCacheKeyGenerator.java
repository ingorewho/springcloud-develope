package com.ignore.common.cache.local.support.interceptor.generator.impl;

import com.ignore.utils.common.Md5Utils;
import org.aspectj.lang.Signature;

/**
 * @Author: ignore1992
 * @Description: 默认key生成器
 * @Date: 2019/1/13
 */
public class DefaultLocalCacheKeyGenerator extends AbstractLocalCacheKeyGenerator{
    @Override
    public Object generate(Object target, Signature method, Object... params) {
        //根据类名+方法名+参数名作为key
        StringBuffer sb = new StringBuffer();
        sb.append(target.getClass().getName());
        sb.append(method.getName());
        for (Object obj : params) {
            sb.append(obj.toString());
        }
        //对得到的key进行md5加密
        return Md5Utils.md5(sb.toString());
    }
}
