package com.ignore.annotation.self.service;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:28 2018/9/10
 * @Modified By:
 */
//@SelfDefine(message = "a")
//@SelfDefine(message = "b")
//@SelfDefine(message = "c")
public class SelfDefineBean
{
    @SelfDefine(message = "长度不能超过10个字符", length = 10)
    private String name;

    public SelfDefineBean(String name)
    {
        this.name = name;
    }
//    @SelfDefine(message = "c")
    public void service(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
