package com.ignore.common.cache.local.support.container;

/**
 * 缓存容器
 */
public interface CacheContainer<K> {

    void put(K key, String value);

    String remove(K key);

    String get(K key);

}