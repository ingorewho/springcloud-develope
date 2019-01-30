package com.ignore.scheduled.business.carepush.config;

import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.scheduled.business.carepush.CareEnum;
import com.ignore.scheduled.business.carepush.CareRequest;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ignore1992
 * @Description: 配置类
 * @Date: Created In 15:09 2019/1/29
 */
@Configuration
public class CarePushConfig {
    @Autowired
    private WeathReqConfig weathReqConfig;

    public CareRequest getCareReques(){
        CareRequest request = new CareRequest();
        request.setCareType(CareEnum.WEATHER);
        WeatherReqParam reqParam = new WeatherReqParam();
        reqParam.setCity(weathReqConfig.getCity());
        request.setData(reqParam);
        return request;
    }
}
