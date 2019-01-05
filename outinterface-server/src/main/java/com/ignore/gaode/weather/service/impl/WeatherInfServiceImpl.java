package com.ignore.gaode.weather.service.impl;

import com.ignore.common.net.http.HttpClientService;
import com.ignore.gaode.weather.service.WeatherInfService;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.utils.map.MapTransferUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Description： 天气查询实现类
 * Author: ignore1992
 * Date: Created in 2019/1/5 16:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class WeatherInfServiceImpl implements WeatherInfService{
    @Value("${outinterface.gaode.weather.url:https://restapi.amap.com/v3/weather/weatherInfo}")
    /**接口地址.**/
    private String interfaceUrl;
    @Value("${outinterface.gaode.weather.key:1c7f35791b076a5ff64ab741549978e5}")
    private String userKey;

    private Logger logger = LogManager.getLogger();
    @Autowired
    private HttpClientService httpClientService;

    @Override
    public String queryWeather(WeatherReqParam reqParam) {
        String result = null;
        try {
            Map<String, Object> param = MapTransferUtils.objectToMap(reqParam);
            param.put("key", userKey);
            result = httpClientService.doGet(interfaceUrl, param);
        } catch (IllegalAccessException e) {
            logger.error("{天气查询}转换请求参数异常! 参数:", reqParam, e);
        }catch (Exception e){
            logger.error("{天气查询}查询外部接口异常! 参数:", reqParam, e);
        }
        return result;
    }
}
