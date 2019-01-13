package com.ignore.common.cache.local.support.strategy;

import com.ignore.common.cache.local.support.annotation.LocalCacheable;
import org.springframework.cache.interceptor.KeyGenerator;

/**
 * @Author: ignore1992
 * @Description: 本地缓存策略接口
 * @Date: 2019/1/13
 */
public interface LocalCacheableStrategy {

    KeyGenerator getKeyGenerator(LocalCacheable localCacheable);
}
