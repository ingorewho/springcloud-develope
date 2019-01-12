package com.ignore.common.cache.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @Author: ignore1992
 * @Description: 缓存配置
 * @Date: 2019/1/12
 */
@Configuration
public class RedisCacheConfig{
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        CommonRedisTemplate template = new CommonRedisTemplate();
        setSerializer(template);
        template.setConnectionFactory(factory);
        template.afterPropertiesSet();
        return template;
    }

    private void setSerializer(CommonRedisTemplate template){
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //设置value的序列化器
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
    }
}
