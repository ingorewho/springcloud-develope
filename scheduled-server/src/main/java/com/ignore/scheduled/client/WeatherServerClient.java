package com.ignore.scheduled.client;

import com.ignore.common.frame.spring.aop.log.OutputLog;
import com.ignore.cons.ServerConfigConst;
import com.ignore.dto.ResultDTO;
import com.ignore.options.weather.WeatherOption;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.scheduled.client.fallback.WeatherServerClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: ignore1992
 * @Description: 调用天气服务客户端
 * @Date: 2019/1/27
 */
@FeignClient(value = ServerConfigConst.WEATHER_SERVER, fallback = WeatherServerClientFallback.class)
public interface WeatherServerClient {
    @PostMapping(value = "/weather/option")
    ResultDTO<WeatherOption> getWeatherOption(@RequestBody WeatherReqParam weatherReqParam);
}
