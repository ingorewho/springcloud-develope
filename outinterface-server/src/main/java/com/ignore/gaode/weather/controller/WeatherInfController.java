package com.ignore.gaode.weather.controller;

import com.ignore.common.frame.spring.aop.log.OutputLog;
import com.ignore.cons.ServerConfigConst;
import com.ignore.dto.ResultDTO;
import com.ignore.gaode.weather.service.WeatherInfService;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.response.outinterface.gaode.weather.WeatherResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description： 高德-天气查询接口
 * Author: ignore1992
 * Date: Created in 2019/1/5 16:12
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@RestController
public class WeatherInfController {
    @Resource(name = "weatherInfServiceImpl")
    private WeatherInfService weatherInfService;

    @OutputLog(desc = "调用高德接口查询天气信息")
    @PostMapping(value = "/weather/query")
    public ResultDTO<WeatherResponse> queryWeather(@RequestBody WeatherReqParam reqParam){
        return new ResultDTO<WeatherResponse>(weatherInfService.queryWeather(reqParam));
    }
}
