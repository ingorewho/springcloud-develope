package com.ignore.annotation.self.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:44 2018/9/10
 * @Modified By:
 */
public class SelfDefineService
{
    public static void getAnnotation()
    {
        //判断Class类是否包含某个类型的注解
        //如果SelfDefineBean被多个@SelfDefine注解，则注解类型会是SelfDefines.class，即下面得到的结果将是false
        boolean flag = SelfDefineBean.class.isAnnotationPresent(SelfDefine.class);
        if (flag)
        {
            SelfDefine annotation = SelfDefineBean.class.getAnnotation(SelfDefine.class);
            System.out.println("注解信息message:" + annotation.message());
        }
    }

    /**
     * 获取类上所有注解，不包含属性
     */
    public static void getAnnations()
    {
        Class aClass = SelfDefineBean.class;
        Annotation[] annotations = aClass.getAnnotations();
        List<Annotation> list = Arrays.asList(annotations);
        System.out.println("获取该类上的所有注解个数: " + annotations.length);
    }

    /**
     * 根据注解类型获取一个类上的所有注解
     * 如果查询的是类，则会检测对应的重复注解容器，还会去父类检测对应的注解
     */
    public static void getAnnationByType()
    {
        Class aClass = SelfDefineBean.class;
        Annotation[] annotations = aClass.getAnnotationsByType(SelfDefine.class);
        List<Annotation> list = Arrays.asList(annotations);
        System.out.println("根据特定类型获取该类上的所有注解个数: " + annotations.length);
    }

    /**
     * 返回直接存在于此元素上的所有注解。与此接口中的其他方法不同，该方法将忽略继承的注释。如果没有注释直接存在于此元素上，则返回null
     */
    public static void getDeclaredAnnotation()
    {
        Class aClass = SelfDefineBean.class;
        Annotation[] annotations = aClass.getDeclaredAnnotations();
        List<Annotation> list = Arrays.asList(annotations);
        System.out.println("根据特定类型获取该类上的所有注解个数: " + annotations.length);
    }
    /**
     * 判断一个类或接口是否被注解修饰
     */
    public static void isAnnotation()
    {
        boolean flag = SelfDefineBean.class.isAnnotation();
        System.out.println("SelfDefineBean被注解修饰:" + flag);
    }

    /**
     * 获取注解的类型
     */
    public static void getAnnotatedInterfaces()
    {
        AnnotatedType[] interfaces = SelfDefine.class.getAnnotatedInterfaces();
        List<AnnotatedType> list = Arrays.asList(interfaces);
        System.out.println("SelfDefine的AnnotatedType集合: " + list);
    }

    /**
     * 获取从哪个类继承了注解
     */
    public static void getAnnotatedSuperclass()
    {
        AnnotatedType parentType = SelfDefineBeanChild.class.getAnnotatedSuperclass();
        System.out.println("SelfDefineBeanChild父类型:" + parentType.getType());
        System.out.println("SelfDefine类型:" + SelfDefine.class.getAnnotations()[0]);
    }

    /**
     * 获取属性的注解信息
     */
    public static void getFiledAnnoation()
    {
        Class<?> selftClass = SelfDefineBean.class;
        try
        {
            //可以获取私有属性
            Field nameField = selftClass.getDeclaredField("name");
            //私有属性需要设置权限
            nameField.setAccessible(true);
            //获取属性的指定注解
            Annotation annotation = nameField.getAnnotation(SelfDefine.class);
            System.out.println("name属性的注解信息: " + annotation);
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取方法的注解
     */
    public static void getMethodAnnatition()
    {
        Class<?> aClass = SelfDefineBean.class;
        try
        {
            Method service = aClass.getDeclaredMethod("service", String.class);
            service.setAccessible(true);
            Annotation annotation = service.getAnnotation(SelfDefine.class);
            System.out.println("方法的注解信息: " + annotation);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 对注解的内容进行校验
     */
    public static void validFieldLength()
    {
        SelfDefineBean bean = new SelfDefineBean("12345678999");
        Class<?> aClass = bean.getClass();
        Field[] fields = aClass.getDeclaredFields();
        try
        {
            for (Field aField : fields)
            {
//                aField.setAccessible(true);
                //这里为什么一直返回false？？？
                if(aField.isAnnotationPresent(SelfDefine.class))
                {
                    //获取属性值长度
                    int length = aField.get(bean).toString().length();
                    if (length > aField.getAnnotation(SelfDefine.class).length())
                    {
                        System.out.println(String.format("属性:%s,值长度超长", aField.getName()));
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
