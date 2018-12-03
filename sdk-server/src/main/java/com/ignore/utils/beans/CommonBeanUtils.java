package com.ignore.utils.beans;

import lombok.Data;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 14:45 2018/11/29
 */
public class CommonBeanUtils {
    public static PropertyDescriptor getPropertyDescriptor(Class<?> aClass, String propertyName)throws Exception{
        Assert.notNull(aClass, "class对象不能为null!");
        return new PropertyDescriptor(propertyName, aClass);
    }

    public static void main(String[] args)throws Exception
    {
        A a = new A("test");
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(a.getClass(), "name");
        //属性读取
        Method readMethod = propertyDescriptor.getReadMethod();
        System.out.println(readMethod.invoke(a));
        //属性写值
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(a, "test1");
        System.out.println(a.getName());
    }
}
@Data
class A{
    private String name;
    public A(String name){
        this.name = name;
    }
}
