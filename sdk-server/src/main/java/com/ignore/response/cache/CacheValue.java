package com.ignore.response.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:33 2019/1/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheValue<V> {
    /**缓存value值.**/
    private V value;
    /**缓存有效期时间戳.**/
    private long expireTime;
}
