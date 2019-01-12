package com.ignore.common.cache.local.interceptor.generator;

import com.ignore.utils.common.Md5Utils;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @Author: ignore1992
 * @Description: 本地缓存key生成器
 * @Date: 2019/1/12
 */
public class LocalCacheKeyGenerator implements KeyGenerator{
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return new KeyGenerator() {
            public Object generate(Object target, Method method, Object... params) {
                //根据类名+方法名+参数名作为key
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                //对得到的key进行md5加密
                String md5Str = Md5Utils.md5(sb.toString());
                //加密后是32位，为了减少key的长度，隔位取偶数位得到16位的key
                return appendEvenChar(md5Str);
            }
        };
    }

    /**
     * 拼接偶数位字符
     * @param src
     * @return
     */
    private String appendEvenChar(String src){
        StringBuffer buffer = new StringBuffer();
        char[] chars = src.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if ((i % 2) == 0){
                buffer.append(i);
            }
        }
        return buffer.toString();
    }
}
