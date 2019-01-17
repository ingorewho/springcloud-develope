package com.ignore.utils.map;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ignore1992
 * @Description： map转换工具类
 * @Date: Created in 2019/1/5 18:00
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
