package com.ignore.scheduled.client.fallback;

import com.ignore.dto.ResultDTO;
import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.scheduled.client.WeatherServerClient;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: 天气服务降级逻辑
 * @Date: 2019/1/27
 */
@Component
public class WeatherServerClientFallback implements WeatherServerClient{

    @Override
    public ResultDTO<WeatherOption> getWeatherOption(WeatherReqParam weatherReqParam) {
        WeatherOption option = new WeatherOption();
        option.setKindlyOption("服务暂时有点忙! 不打紧，一会您再试下.");
        ResultDTO<WeatherOption> resultDTO = new ResultDTO<>(option);
        return resultDTO;
    }
}
