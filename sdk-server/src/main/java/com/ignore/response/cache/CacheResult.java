package com.ignore.response.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:14 2019/1/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheResult<K, V> {
    /**缓存key.**/
    private K key;
    /**缓存value.**/
    private V value;
    /**缓存是否成功.**/
    private boolean success;
    /**缓存异常信息.**/
    private String message;
}
