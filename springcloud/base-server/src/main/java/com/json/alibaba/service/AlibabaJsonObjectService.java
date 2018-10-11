package com.json.alibaba.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * JSONObject继承了JSON抽象类，继承了JSON的所有方法，并自定义了操作属性的一系列方法
 * @Date: Created In 17:33 2018/9/19
 * @Modified By:
 */
public class AlibabaJsonObjectService
{
    /**
     * 创建JSONObject
     */
    public static void create()
    {
        //指定初始容量，如果指定ordered为true，则内部创建并使用LinkedHashMap类型的map实例
        JSONObject obj = new JSONObject(1024, true);
        //默认初始容量为16，内部创建并使用使用HashMap类型
        JSONObject obj2 = new JSONObject();
    }

    /**
     * JSONObject主要提供一些get操作，从内部map中获取对象
     */
    public static void get()
    {
        String data = "{\"request\":\"hello\",\"response\":\"world\"}";
        JSONObject jsonObject = JSON.parseObject(data);
        System.out.println("get: " + jsonObject.get("request"));
        System.out.println("getInnerMap: " + jsonObject.getInnerMap());
        System.out.println("getString: " + jsonObject.getString("request"));
        System.out.println();
    }


}
