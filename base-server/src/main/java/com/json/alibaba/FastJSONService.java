package com.json.alibaba;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:39 2018/9/27
 */
public class FastJSONService {
    /**
     * FastJSON原理： 
     *-对象 to JSON ：利用反射找到对象类的所有Get方法，然后把"get"去掉，小写化，作为JSON的每个key值，如 getA  对应的key值为 a，而与真实的类成员名无关。
     *-JSON to pojo ：先同样通过反射找到对象类所有的Set方法，然后使用无参数构造函数（所以一定要有无参数的构造函数）新建一个类对象，从JSON字符串中取出一个key 如 a，先大写化为A，那么从所有Set方法中找到 SetA()，然后进行赋值。 如果找不到 setA （seta也不行），那么该值被忽略，也不报错。
     *
     * Jackson 的原理和FastJson一致，但是在 JSON to Java pojo的步骤中，做了更加科学的check，因而能识别seta这样的小写。但是如果getA 和geta都找不到，则会抛出异常
     */

    /**
     * 序列化和反序列化性能对比:
     * 序列化(pojo to com.json):  当循环数量较小时，FastJSON的性能 低于 JackSON；
     *    当循环数量越大时，FastJSON的性能开始超过Jackson；
     *
     * 反序列化( com.json to pojo):当成员数量越大时，FastJSON的相对性能越差，JackSON的相对性能则越好； 
     *   当成员数量越小时，FastJSON的性能越好。
     * 综合(序列化和反序列化):
     * 1.当成员变量数量越大时，Jackson 获胜。无关于循环数量。 
     * 2.当成员变量数量越小时，FastJSON获胜。
     */
}
