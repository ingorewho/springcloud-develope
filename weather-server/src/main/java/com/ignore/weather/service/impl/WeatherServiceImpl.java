package com.ignore.weather.service.impl;

import com.ignore.common.client.OutInterfaceClient;
import com.ignore.dto.ResultDTO;
import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.response.outinterface.gaode.weather.InnerData;
import com.ignore.response.outinterface.gaode.weather.WeatherResponse;
import com.ignore.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description： 天气实现类
 * Author: ignore1992
 * Date: Created in 2019/1/5 19:43
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private OutInterfaceClient outInterfaceClient;

    @Override
    public WeatherOption getWeatherOption(WeatherReqParam weatherReqParam) {
        ResultDTO<WeatherResponse> resultDTO = outInterfaceClient.queryWeather(weatherReqParam);
        if (!resultDTO.emptyData()){
            WeatherResponse response = resultDTO.getData();
            return generateWeatherOption(response);
        }
        return null;
    }

    public WeatherOption generateWeatherOption(WeatherResponse response){
        WeatherOption option = new WeatherOption();
        StringBuilder kindlyOption = new StringBuilder();
        InnerData data = response.getLives().get(0);
        kindlyOption.append("报告时间:").append(data.getReporttime()).append("\n\r");
        kindlyOption.append("所属地区:").append(data.getProvince()).append("-").append(data.getCity()).append("\n");
        kindlyOption.append("天气:").append(data.getWeather()).append("\n");
        kindlyOption.append("温度:").append(data.getTemperature()).append("℃").append("\n");
        kindlyOption.append("风向:").append(data.getWinddirection()).append("\n");
        kindlyOption.append("风力:").append(data.getWindpower()).append("\n");
        kindlyOption.append("空气湿度:").append(data.getHumidity()).append("\n");
        option.setKindlyOption(kindlyOption.toString());
        return option;
    }
}
