package com.ignore.gaode.weather.service;

import com.ignore.parameter.outinterface.gaode.WeatherReqParam;

public interface WeatherInfService {
    /**
     * 查询天气信息
     * @return
     */
    String queryWeather(WeatherReqParam reqParam);
}
