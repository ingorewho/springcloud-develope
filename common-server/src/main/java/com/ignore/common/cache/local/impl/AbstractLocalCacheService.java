package com.ignore.common.cache.local.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ignore.common.cache.local.LocalCacheService;
import com.ignore.response.cache.CacheValue;
import com.ignore.response.cache.CacheResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:57 2019/1/11
 */
public abstract class AbstractLocalCacheService<K, V> implements LocalCacheService<K, V>{
    private Logger logger = LogManager.getLogger();
    /**二级缓存序号.**/
    private String cacheNo;
    /**二级缓存有效期.**/
    private int expireInterval;
    /**二级缓存基础容器.**/
    private Map<K, V> standardCache;
    /**二级缓存包含有效期的容器.**/
    private Map<K, String> extendCache;
    /**二级缓存初始容量大小.**/
    private int cacheInitSize = DEFAULT_CACHE_INITSIZE;
    private static final int DEFAULT_CACHE_INITSIZE = 256;

    public AbstractLocalCacheService(int cacheInitSize){
        this.cacheInitSize = cacheInitSize;
    }

    @Override
    public CacheResult<K, V> put(K key , V value, int expireInterval) {
        if (key == null){
            logger.warn("存放数据到本地缓存,key为null.");
            return new CacheResult<>(key, value, false, "key为null.");
        }
        try {
            if (expireInterval <= 0){
                //缓存永久有效
                standardCache.put(key, value);
            }else {
                //计算有效期
                long expireTime = System.currentTimeMillis() + expireInterval * 10000L;
                CacheValue<V> cacheValue = new CacheValue<>(value, expireTime);
                String jsonValue = JSON.toJSONString(cacheValue);
                extendCache.put(key, jsonValue);
            }

        }catch (Exception e){
            logger.error("存放数据到本地缓存发生异常.", e);
            return new CacheResult<>(key, value, false, "执行put操作发生异常.");
        }
        return new CacheResult<>(key, value, true, null);
    }

    @Override
    public CacheResult<K, V> remove(K key) {
        if (key == null){
            logger.warn("删除本地缓存,key为null.");
            return new CacheResult<>(key, null, false, "key为null.");
        }

        V value = null;
        try {
            value = standardCache.remove(key);
            if (value == null){
                String result = extendCache.remove(key);
                if (StringUtils.isNotBlank(result)){
                    CacheValue<V> cacheValue = JSONObject.toJavaObject(JSON.parseObject(result), CacheValue.class);
                    value = cacheValue.getValue();
                }
            }
        }catch (Exception e){
            logger.error("存放数据到本地缓存发生异常.", e);
            return new CacheResult<>(key, value, false, "执行remove操作发生异常.");
        }
        return new CacheResult<>(key, value, true, null);
    }


    @Override
    public CacheResult<K, V> get(K key) {
        if (key == null){
            logger.warn("获取本地缓存,key为null.");
            return new CacheResult<>(key, null, false, "key为null.");
        }

        V value = null;
        try {
            value = standardCache.get(key);
            if (value == null){
                String result = extendCache.get(key);
                if (StringUtils.isNotBlank(result)){
                    CacheValue<V> cacheValue = JSONObject.toJavaObject(JSON.parseObject(result), CacheValue.class);
                    value = cacheValue.getValue();
                }
            }
        }catch (Exception e){
            logger.error("存放数据到本地缓存发生异常.", e);
            return new CacheResult<>(key, value, false, "执行remove操作发生异常.");
        }
        return new CacheResult<>(key, value, true, null);
    }
}
