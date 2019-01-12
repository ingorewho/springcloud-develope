package com.ignore.weather.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ignore.common.client.OutInterfaceClient;
import com.ignore.dto.ResultDTO;
import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.response.outinterface.gaode.weather.WeatherResponse;
import com.ignore.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description： 天气实现类
 * Author: ignore1992
 * Date: Created in 2019/1/5 19:43
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private OutInterfaceClient outInterfaceClient;

    @Override
    public WeatherOption getWeatherOption(WeatherReqParam weatherReqParam) {
        ResultDTO<String> resultDTO = outInterfaceClient.queryWeather(weatherReqParam);
        if (!resultDTO.emptyData()){
            JSONObject.toJavaObject(resultDTO.getData(), WeatherResponse.class);
        }
        return null;
    }
}
