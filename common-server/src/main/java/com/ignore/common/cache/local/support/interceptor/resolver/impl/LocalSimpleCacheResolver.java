package com.ignore.common.cache.local.support.interceptor.resolver.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ignore.common.cache.local.support.interceptor.resolver.LocalCacheResolver;
import com.ignore.response.cache.CacheValue;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ignore1992
 * @Description: simple缓存解析器
 * @Date: 2019/1/12
 */
public class LocalSimpleCacheResolver<V> implements LocalCacheResolver<V>{
    /**空对象.**/
    private CacheValue emptyCacheValue = new CacheValue();

    @Override
    public String serialValue(V value, int expireInterval) {
        //计算有效期
        long expireTime = System.currentTimeMillis() + expireInterval * 10000L;
        CacheValue<V> cacheValue = new CacheValue<>(value, expireTime);
        return JSON.toJSONString(cacheValue);
    }

    @Override
    public CacheValue<V> deserialValue(String value) {
        if (StringUtils.isNotBlank(value)){
            return JSONObject.toJavaObject(JSON.parseObject(value), CacheValue.class);
        }
        return emptyCacheValue;
    }
}
