package com.ignore.response.outinterface.gaode.weather;

import lombok.Data;

/**
 * @Author: ignore1992
 * @Description: 天气接口返回的内部数据结构
 * @Date: Created In 15:51 2019/1/29
 */
@Data
public class InnerData {
    private String province;
    private String city;
    private String adcode;
    private String weather;
    private String temperature;
    private String winddirection;
    private String windpower;
    private String humidity;
    private String reporttime;
}
