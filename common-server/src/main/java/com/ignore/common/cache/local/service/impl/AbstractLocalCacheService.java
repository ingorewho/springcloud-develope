package com.ignore.common.cache.local.service.impl;

import com.ignore.common.cache.local.interceptor.generator.LocalCacheKeyGenerator;
import com.ignore.common.cache.local.interceptor.resolver.LocalCacheResolver;
import com.ignore.common.cache.local.service.LocalCacheService;
import com.ignore.common.cache.local.support.container.CacheContainer;
import com.ignore.response.cache.CacheResult;
import com.ignore.response.cache.CacheValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

/**
 * @Author: ignore1992
 * @Description: 二级缓存抽象类，实现了缓存有效期功能
 * @Date: Created In 16:57 2019/1/11
 */
public abstract class AbstractLocalCacheService<K, V> implements LocalCacheService<K, V>{
    private Logger logger = LogManager.getLogger();
    /**二级缓存序号.**/
    private String cacheNo;
    /**二级缓存有效期.**/
    protected int expireInterval;
    /**二级缓存基础容器.**/
    protected CacheContainer container;
    /**二级缓存初始容量大小.**/
    protected int cacheInitSize;
    /**缓存解析器.**/
    protected LocalCacheResolver<V> cacheResolver;

    public AbstractLocalCacheService(){
        //初始化容器
        initialize();
    }

    protected abstract void initialize();

    @Override
    public CacheResult<K, V> put(K key , V value, int expireInterval) {
        Assert.isNull(key, "存放数据到本地缓存,key为null.");

        try {
            container.put(key, cacheResolver.serialValue(value, expireInterval));
        }catch (Exception e){
            logger.error("存放数据到本地缓存发生异常.", e);
            return new CacheResult<>(key, value, false, "执行put操作发生异常.");
        }
        return new CacheResult<>(key, value, true, null);
    }

    @Override
    public CacheResult<K, V> remove(K key) {
        Assert.isNull(key, "删除本地缓存,key为null.");

        V value = null;
        try {
            String result = container.remove(key);
            CacheValue<V> cacheValue = cacheResolver.deserialValue(result);
            value = cacheValue.getValue();
            return new CacheResult<>(key, value, true, null);
        }catch (Exception e){
            logger.error("存放数据到本地缓存发生异常.", e);
            return new CacheResult<>(key, value, false, "执行remove操作发生异常.");
        }
    }


    @Override
    public CacheResult<K, V> get(K key) {
        Assert.isNull(key, "获取本地缓存,key为null.");

        V value = null;
        try {
            String result = container.get(key);
            CacheValue<V> cacheValue = cacheResolver.deserialValue(result);
            if (cacheValue.getExpireTime() >= System.currentTimeMillis()){
                //数据未过期
                value = cacheValue.getValue();
                return new CacheResult<>(key, value, true, null);
            }
            return new CacheResult<>(key, value, false, null);
        }catch (Exception e){
            logger.error("存放数据到本地缓存发生异常.", e);
            return new CacheResult<>(key, value, false, "执行remove操作发生异常.");
        }
    }
}
