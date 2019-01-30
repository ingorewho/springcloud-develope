package com.ignore.gaode.weather.service;

import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.response.outinterface.gaode.weather.WeatherResponse;

public interface WeatherInfService {
    /**
     * 查询天气信息
     * @return
     */
    WeatherResponse queryWeather(WeatherReqParam reqParam);
}
