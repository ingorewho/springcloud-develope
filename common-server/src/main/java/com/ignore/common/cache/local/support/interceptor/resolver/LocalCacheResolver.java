package com.ignore.common.cache.local.support.interceptor.resolver;

import com.ignore.response.cache.CacheValue;

/**
 * @Author: ignore1992
 * @Description: 本地缓存解析
 * @Date: 2019/1/12
 */
public interface LocalCacheResolver<V> {
    String serialValue(V value, int expireInterval);

    CacheValue<V> deserialValue(String value);
}
