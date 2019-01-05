package com.ignore.utils.map;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Description： map转换工具类
 * Author: ignore1992
 * Date: Created in 2019/1/5 18:00
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class MapTransferUtils {

    /**
     * 对象转HashMap
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            String key = field.getName();
            Object value = field.get(obj);
            if (value != null){
                map.put(key, value);
            }
        }
        return map;
    }
}
