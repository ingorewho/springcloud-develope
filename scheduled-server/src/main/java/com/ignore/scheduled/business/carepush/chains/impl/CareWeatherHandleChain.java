package com.ignore.scheduled.business.carepush.chains.impl;

import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.scheduled.business.carepush.chains.CareHandleChainRegister;
import com.ignore.scheduled.client.WeatherServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: 天气处理链
 * @Date: 2019/1/27
 */
@Component
public class  CareWeatherHandleChain extends AbstractCareHandleChain<WeatherReqParam>{
    @Autowired
    private CareHandleChainRegister careHandleChainRegister;
    @Autowired
    private WeatherServerClient weatherServerClient;

    public CareWeatherHandleChain(){
        super("weather");
        careHandleChainRegister.registChain(this);
    }

    @Override
    protected String handle(WeatherReqParam data) {
        WeatherOption option = weatherServerClient.getWeatherOption(data).getData();
        if (option != null){
            return option.getKindlyOption();
        }
        return null;
    }
}
