package com.ignore.parameter.outinterface.gaode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class WeatherReqParam {
    /**城市编码.**/
    private String city;
    /**气象类型可选值：base/all base:返回实况天 all:返回预报天气.**/
    private String extensions;
    /**返回格式.**/
    private String output;
}
