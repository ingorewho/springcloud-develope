package com.ignore.common.cache.local;

import com.ignore.response.cache.CacheResult;

public interface LocalCacheService<K, V> {
    CacheResult<K, V> put(K key , V value, int expireInterval);

    CacheResult<K, V> remove(K key);

    CacheResult<K, V> get(K key);
}
