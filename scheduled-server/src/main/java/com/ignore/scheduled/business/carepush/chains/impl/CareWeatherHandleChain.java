package com.ignore.scheduled.business.carepush.chains.impl;

import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.scheduled.business.carepush.CareEnum;
import com.ignore.scheduled.business.carepush.CareResult;
import com.ignore.scheduled.business.carepush.chains.CareHandleChainRegister;
import com.ignore.scheduled.client.WeatherServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: 天气处理链
 * @Date: 2019/1/27
 */
@Component
public class  CareWeatherHandleChain extends AbstractCareHandleChain<WeatherReqParam>{
    @Autowired
    private WeatherServerClient weatherServerClient;

    @Autowired
    public CareWeatherHandleChain(CareHandleChainRegister careHandleChainRegister){
        super(CareEnum.WEATHER);
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

    @Value("${weather.chain.push.strategy:mail}")
    public void setPushType(String strategy) {
        super.strategyName = strategy;
    }
}
