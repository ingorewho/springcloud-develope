package com.ignore.json.test;

import com.ignore.json.alibaba.service.AlibabaJsonSerialService;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 13:45 2018/9/14
 * @Modified By:
 */
public class TestAlibabaJson
{
    public static void main(String[] args)
    {
        //序列化
        AlibabaJsonSerialService.toJson();
        AlibabaJsonSerialService.toJSONString();
        AlibabaJsonSerialService.toJSONBytes();
        //反序列化
//        AlibabaJsonDeserialService.jsonParse();
//        AlibabaJsonDeserialService.jsonParseObject();
//        AlibabaJsonDeserialService.jsonParseArray();
    }
}
