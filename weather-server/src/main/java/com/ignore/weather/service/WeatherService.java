package com.ignore.weather.service;

import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;

public interface WeatherService {
    WeatherOption getWeatherOption(WeatherReqParam weatherReqParam);
}
