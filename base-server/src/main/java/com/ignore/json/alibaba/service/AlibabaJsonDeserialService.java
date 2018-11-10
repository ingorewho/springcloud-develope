package com.ignore.json.alibaba.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.ignore.json.alibaba.entity.Animal;
import com.ignore.json.alibaba.entity.Person;

import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 *  综述:反序列化
 * 1.JSONObject继承于JSON抽象类，所以在用父类方法时，尽量调用父类
 * 2.JSON主要用于json序列化和反序列化
 * 3.JSONArray，JSONObject
 * @Date: Created In 11:41 2018/9/14
 * @Modified By:
 */
public class AlibabaJsonDeserialService
{
    /**
     * JSON类反序列化入口:parse、parseObject、parserArray
     * 1.这些方法的实现，实际托付给了DefaultJSONParser类
     * 2.DefaultJSONParser类相当于序列化的JSONSerializer类,是个功能组合器
     * 3.将上层调用、反序列化配置、反序列化实现、词法解析等功能组合在一起，相当于设计模式中的外观模式，供外部统一调用
     */

    /**
     * JSONLexer接口类：定义了各种当前状态和操作接口
     * 1.JSONLexerBase是对JSONLexer实现的抽象类，类似于序列化的SerializeWriter类，专门解析json字符串，并做了很多优化。
     * 2.实际使用的是JSONLexerBase的两个子类JSONScanner和JSONLexerBase
     * 3.JSONScanner是对整个字符串的反序列化，JSONLexerBase是接Reader直接序列化
     *
     * JSONLexerBase有很多成员，我们常见的有Feature、ParseConfig
     * 这里说明下期中的Feature成员属性：
     * 1.反序列化特性的配置，同序列化的feature是通过int的位或来实现其特性开启还是关闭的。
     * 2.默认配置是： AutoCloseSource | UseBigDecimal | AllowUnQuotedFieldNames | AllowSingleQuotes | AllowArbitraryCommas | AllowArbitraryCommas | SortFeidFastMatch | IgnoreNotMatch
     * 3.分别对应表示：检查json串的完整性 and 转换数值使用BigDecimal and 允许接受不使用引号的filedName and 允许接受使用单引号的key和value and 允许接受连续多个","的json串 and 使用排序后的field做快速匹配 and 忽略不匹配的key/value对。当然，这些参数也是可以通过其他途径配置的。
     */

    /**
     * 反序列化操作：parse()
     * 将String或者byte[] 数组parse为Object，这个Object可以被JSONObject或JSONArray接收。
     */
    public static void jsonParse()
    {
        String json = "{\"request:\":\"hello\",\"result\":\"haha\"}";
        System.out.println(json.length());
        Object object = JSON.parse(json);
        System.out.println(object);
        //Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。双精度浮点型变量double可以处理16位有效数。在实际应用中，需要对更大或者更小的数进行运算和处理。float和double只能用来做科学计算或者是工程计算，在商业计算中要用java.math.BigDecimal
        //默认使用的是DEFAULT_PARSER_FEATURE，包括了Feature的七种枚举类型
        object = JSON.parse(json, Feature.UseBigDecimal);
        System.out.println(object);
        //将json串字节数组转为JSONObject或JSONArray可以接收的Object
        JSON.parse(json.getBytes(), Feature.UseBigDecimal);
        System.out.println(object);
        //ParserConfig是反序列化配置,其中的boolean asmEnable同样判断是否为Andriod环境
        System.out.println(JSON.parse(json, ParserConfig.getGlobalInstance()));
        //解析指定数组长度(解析时不包含len的最后一位)、使用指定编码、指定特征
        System.out.println(JSON.parse(json.getBytes(), 0, 36, Charset.forName("utf-8").newDecoder(), Feature.UseBigDecimal));
    }


    /**
     * 反序列化操作：parseObject()
     * 这系列方法可以把String或者byte[] parse为自己定义的实体类，也可以是其他jar包的数据类型，只要在后面指明它的类型就好了
     */
    public static void jsonParseObject()
    {
        String json = "{\"request:\":\"hello\",\"result\":\"haha\"}";
        //1.默认解析成JSONObject类型
        JSONObject object = JSON.parseObject(json);
        System.out.println(object);
        //2.指定具体泛型类型(必须是pulic修饰的类,可以不实现序列号接口)
        Person person =JSON.parseObject(json, Person.class);
        System.out.println(person);
        //3.Type体系中类型的包括：原始类型(Class)、参数化类型(ParameterizedTypes)、数组类型(GenericArrayType)、类型变量(TypeVariable)、基本类型
        System.out.println(JSON.parseObject(json, new TypeReference<Person<String>>(){},Feature.UseBigDecimal));
        //4.指定Type类型和特征，如果是泛型类型，最好用方式3
        System.out.println(JSON.parseObject(json, Person.class, Feature.UseBigDecimal));
    }

    public static void jsonParseArray()
    {
        String jsonArray = "[{\"request\":\"hello\",\"result\":\"haha\"},{\"request\":\"hello1\",\"result\":\"haha1\"}]";
        //指定类型解析得到Person对象数组(必须是pulic修饰的类,可以不实现序列号接口)
        System.out.println(JSON.parseArray(jsonArray, Person.class));
        //不指定类型，则默认转为JSONArray类型数组
        System.out.println(JSON.parseArray(jsonArray));
        //指定类型数组
        System.out.println(JSON.parseArray(jsonArray, new Type[]{Person.class, Animal.class}));
    }

}




