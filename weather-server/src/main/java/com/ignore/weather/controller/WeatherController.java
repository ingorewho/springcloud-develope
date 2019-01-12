package com.ignore.weather.controller;

import com.ignore.cons.ServerConfigConst;
import com.ignore.dto.ResultDTO;
import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2019/1/5 19:31
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@RestController
@RequestMapping(ServerConfigConst.WEATHER_SERVER)
public class WeatherController {
    @PostMapping(value = "/weather/option")
    public ResultDTO<WeatherOption> getWeatherOption(WeatherReqParam weatherReqParam){

    }
}
