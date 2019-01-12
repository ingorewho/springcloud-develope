package com.ignore.common.cache;

import com.ignore.common.cache.redis.config.CommonRedisTemplate;
import com.ignore.common.cache.redis.handler.RedisCacheErrorHandler;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.lang.reflect.Method;

/**
 * @Author: ignore1992
 * @Description: 缓存配置
 * @Date: 2019/1/12
 */
@Configuration
@EnableCaching
public class CommonCacheConfig extends CachingConfigurerSupport {
    public CommonCacheConfig() {
        super();
    }

    @Bean
    public CacheManager cacheManager(CommonRedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        return redisCacheManager;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            public Object generate(Object target, Method method, Object... params) {
                //根据类名+方法名+参数名作为key
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    @Bean
    public CacheErrorHandler errorHandler() {
        return new RedisCacheErrorHandler();
    }
}
