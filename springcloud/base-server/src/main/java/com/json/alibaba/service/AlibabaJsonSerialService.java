package com.json.alibaba.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.*;
import com.json.alibaba.entity.Person;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * 综述:使用alibaba进行序列化操作
 *  JSON是一个抽象类，该类实现了JSONAware（转为json串）和JSONStreamAware（将json串写入Appendable中）的接口，同时又是JSONArray（内部实现就是个List）和JSONObject（内部实现就是个Map）的父类
 * @Date: Created In 19:45 2018/9/18
 * @Modified By:
 */
public class AlibabaJsonSerialService
{
    /**
     * JSON类反序列化入口:JSON.toJSONString()
     * 1.这些方法的实现，实际托付给了JSONSerializer类
     * 2.JSONSerializer类相当于一个序列化组合器
     * 3.它将上层调用、序列化配置、具体类型序列化实现、序列化字符串拼接等功能组合在一起，方便外部统一调用
     * 4.有几个重要的成员，SerializeConfig、SerializeWriter、各种Filter列表、DateFormat、SerialContext等
     */

    /**
     * SerializeConfig:全局唯一，继承自IdentityHashMap(IdentityHashMap实现了HashMap的功能，但能避免HashMap并发时的死循环)
     * 主要功能:配置并记录每种Java类型对应的序列化类（ObjectSerializer接口的实现类）
     *  比如:Boolean.class使用BooleanCodec
     */

    /**
     * SerializeWriter:继承自Java的Writer，其实就是个转为FastJSON而生的StringBuilder，完成高性能的字符串拼接
     * SerializeWriter有诸多属性:writer、feature等等
     * 这里说明下feature属性:
     * 1.生成json字符串的特征配置
     * 2.默认配置为:QuoteFieldNames | SkipTransientField | WriteEnumUsingToString | SortField
     * 3.分别对应:输出key时是否使用双引号,默认为true|类中的Get方法对应的Field是transient，序列化时将会被忽略|读枚举的value值|按字段名称排序后输出
     */

    /**
     * Filter列表:在生成json串的各阶段、各地方定制序列化
     * 1.BeforeFilter ：序列化时在最前面添加内容
     * 2.AfterFilter ：序列化时在最后面添加内容
     * 3.PropertyFilter ：根据PropertyName和PropertyValue来判断是否序列化
     * 4.ValueFilter ：修改Value
     * 5.NameFilter ：修改key
     * 6.PropertyPreFilter ：根据PropertyName判断是否序列化
     */

    /**
     * 序列化操作：toJson()
     */
    public static void toJson()
    {
        Person<String> aPerson = new Person<>("hello", "world");
        //转成JSON类型的对象
        System.out.println(JSON.toJSON(aPerson));
        //指定序列化配置
        System.out.println(JSON.toJSON(aPerson, SerializeConfig.globalInstance));
        //将JSON类型的对象序列化为Java对象
        String json = "{\"request\":\"hello\",\"result\":\"haha\"}";
        System.out.println(JSON.toJavaObject(JSON.parseObject(json), Person.class));
    }

    /**
     * 序列化操作:toJSONBytes()
     */
    public static void toJSONBytes()
    {
        Person<String> aPerson = new Person<>("hello", "world");
        //指定序列化特征，序列化为字节数组
        System.out.println(JSON.toJSONBytes(aPerson, SerializerFeature.NotWriteDefaultValue));
    }

    /**
     * 序列化操作:toJSONString()
     */
    public static void toJSONString()
    {
        Person<String> aPerson = new Person<>("hello", "world");
        //使用before过滤器，在序列化前进行操作，after过滤器也类似，只是在序列化后进行操作
        SerializeFilter filter = new BeforeFilter()
        {
            @Override
            public void writeBefore(Object o)
            {
                writeKeyValue("test","hello");
            }
        };
        System.out.println("BeforeFilter：" + JSON.toJSONString(aPerson , filter));
        //使用NameFilter，在序列化时改key，ValueFilter也类似，在序列化时改value
        SerializeFilter nameFilter = new NameFilter()
        {
            @Override
            public String process(Object o , String key , Object value)
            {
                if(key.equals("request"))
                {
                    return "REQUEST";
                }
                return key;
            }
        };
        System.out.println("NameFilter：" + JSON.toJSONString(aPerson, nameFilter));
        //使用SimplePropertyPreFilter,只序列化一部分字段，将序列化的字段配置到数组中
        SerializeFilter propertyPreFilter = new SimplePropertyPreFilter(new String[]{"request"});
        System.out.println("SimplePropertyPreFilter： " + JSON.toJSONString(aPerson, propertyPreFilter));
        //使用PropertyFilter,根据key和value判断是否需要序列化
        SerializeFilter propertyFilter = new PropertyFilter()
        {
            @Override
            public boolean apply(Object o , String key , Object value)
            {
                if(key.equals("request"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        };
        System.out.println("PropertyFilter：" + JSON.toJSONString(aPerson, propertyFilter));
    }


}
