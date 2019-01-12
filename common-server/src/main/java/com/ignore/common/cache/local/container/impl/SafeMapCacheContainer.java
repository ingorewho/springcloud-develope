package com.ignore.common.cache.local.container.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ignore1992
 * @Description: 安全的HashMap缓存容器
 * @Date: 2019/1/12
 */
public class SafeMapCacheContainer extends AbstractCacheContainer<String> {
    private Map<String, String> safeMapCache;

    public SafeMapCacheContainer(int containerSize){
        initContainer(containerSize);
    }

    @Override
    protected void initContainer(int containerSize) {
        safeMapCache = new ConcurrentHashMap<>(containerSize);
    }

    @Override
    public void put(String key, String value) {
        safeMapCache.put(key, value);
    }

    @Override
    public String remove(String key) {
        return safeMapCache.remove(key);
    }

    @Override
    public String get(String key) {
        return safeMapCache.get(key);
    }
}
