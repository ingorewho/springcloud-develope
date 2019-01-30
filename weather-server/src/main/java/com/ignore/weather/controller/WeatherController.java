package com.ignore.weather.controller;

import com.ignore.common.frame.spring.aop.log.OutputLog;
import com.ignore.dto.ResultDTO;
import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.weather.service.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2019/1/5 19:31
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@RestController
public class WeatherController {
    @Autowired
    private WeatherServiceImpl weatherService;
    @PostMapping(value = "/weather/option")
    @OutputLog(desc = "查询天气提示信息")
    public ResultDTO<WeatherOption> getWeatherOption(@RequestBody WeatherReqParam weatherReqParam){
        return new ResultDTO<>(weatherService.getWeatherOption(weatherReqParam));
    }
}
