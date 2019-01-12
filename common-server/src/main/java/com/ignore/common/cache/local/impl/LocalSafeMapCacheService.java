package com.ignore.common.cache.local.impl;

import com.ignore.common.cache.local.container.CacheContainerDefinition;
import com.ignore.common.cache.local.container.CacheContainerEnum;
import com.ignore.common.cache.local.container.CacheContainerFactory;
import com.ignore.utils.common.DateUtils;
import org.springframework.stereotype.Service;

/**
 * @Author: ignore1992
 * @Description: 使用安全的map实现二级缓存
 * @Date: 2019/1/12
 */
@Service
public class LocalSafeMapCacheService extends AbstractLocalCacheService<String, String>{
    /**默认容器大小**/
    private static final int DEFAULT_SAFE_MAPCAHE_SIZE = 256;
    /**默认有效期无限期.**/
    private static final int DEFAULT_SAFE_MAPCACHE_EXPIRE_INTERVAL = 520 * DateUtils.ONE_YEAR_SECODNS;

    public LocalSafeMapCacheService(){
        super();
    }

    @Override
    protected void initialize() {
        if (cacheInitSize == 0){
            cacheInitSize = DEFAULT_SAFE_MAPCAHE_SIZE;
        }
        if (expireInterval <= 0){
            expireInterval = DEFAULT_SAFE_MAPCACHE_EXPIRE_INTERVAL;
        }
        CacheContainerDefinition definition = new CacheContainerDefinition(CacheContainerEnum.SAFEMAP_CACHE_CONTAINER, cacheInitSize);
        container = CacheContainerFactory.getContainer(definition);
    }

}
