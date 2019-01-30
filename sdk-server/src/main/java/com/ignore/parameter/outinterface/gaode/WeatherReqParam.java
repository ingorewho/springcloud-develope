package com.ignore.parameter.outinterface.gaode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Description： 高德-天气查询参数类
 * Author: ignore1992
 * Date: Created in 2019/1/5 16:30
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReqParam implements Serializable, Cloneable{
    private static final long serialVersionUID = -9198549958740236770L;
    /**城市编码.**/
    private String city;
    /**气象类型可选值：base/all base:返回实况天 all:返回预报天气.**/
    private String extensions;
    /**返回格式.**/
    private String output;

    @Override
    public Object clone(){
        Object o = null;
        try {
            o = super.clone();
        }catch (CloneNotSupportedException e){
            //do nothing
        }
        return o;
    }
}
