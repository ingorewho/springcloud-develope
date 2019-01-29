package com.ignore.common.client;

import com.ignore.common.client.fallback.OutInterfaceClientFallback;
import com.ignore.cons.ServerConfigConst;
import com.ignore.dto.ResultDTO;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.response.outinterface.gaode.weather.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = ServerConfigConst.OUTINTERFACE_SERVER, fallback = OutInterfaceClientFallback.class)
public interface OutInterfaceClient {
    @PostMapping(value = "/weather/query")
    ResultDTO<WeatherResponse> queryWeather(@RequestBody WeatherReqParam reqParam);
}
