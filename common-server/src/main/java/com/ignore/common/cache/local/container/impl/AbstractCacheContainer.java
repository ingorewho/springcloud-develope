package com.ignore.common.cache.local.container.impl;

import com.ignore.common.cache.local.container.CacheContainer;

/**
 * @Author: ignore1992
 * @Description: 缓存容器抽象类
 * @Date: 2019/1/12
 */
public abstract class AbstractCacheContainer<K> implements CacheContainer<K>{

    protected abstract void initContainer(int containerSize);
}
