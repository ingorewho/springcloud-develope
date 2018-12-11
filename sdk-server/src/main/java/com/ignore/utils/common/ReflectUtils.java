package com.ignore.utils.common;

import org.springframework.util.Assert;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:06 2018/12/10
 */
public class ReflectUtils {
    /**本地缓存.*/
    private static final Map<Class<?>, Method[]> declaredMethodsCache = new ConcurrentReferenceHashMap<>(256);
    private static final Method[] NO_METHODS = {};

    /**
     * 获取方法集合，包括接口默认方法
     * @param clazz
     * @return
     */
    public static Method[] getDeclaredMethods(Class<?> clazz){
        Assert.notNull(clazz, "Class对象不能为null");
        Method[] result = declaredMethodsCache.get(clazz);
        if (result == null){
            Method[] declaredMethods = clazz.getDeclaredMethods();
            List<Method> defaultMethods = findDefaultMethodsOnInterfaces(clazz);
            if (declaredMethods != null){
                result = new Method[declaredMethods.length + defaultMethods.size()];
                System.arraycopy(declaredMethods, 0, result, 0, declaredMethods.length);
                int index = declaredMethods.length;
                for (Method method : defaultMethods){
                    result[index] = method;
                    index++;
                }
            }else {
                result = declaredMethods;
            }
            declaredMethodsCache.put(clazz, (result.length == 0) ? NO_METHODS : result);
        }

        return result;
    }

    /**
     * 查询类接口的默认方法
     * @param clazz
     * @return
     */
    public static List<Method> findDefaultMethodsOnInterfaces(Class<?> clazz){
        List<Method> result = null;
        for (Class<?> ifz : clazz.getInterfaces()){
            for (Method ifMethod : ifz.getMethods()){
                //接口方法虽然没有显示写abstract修饰符，但其修饰符就是abstract
                if (!Modifier.isAbstract(ifMethod.getModifiers())){
                    if (result == null){
                        result = new LinkedList<>();
                    }
                    result.add(ifMethod);
                }
            }
        }

        return result;
    }

}
