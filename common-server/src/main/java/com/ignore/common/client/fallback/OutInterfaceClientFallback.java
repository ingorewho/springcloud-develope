package com.ignore.common.client.fallback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ignore.common.client.OutInterfaceClient;
import com.ignore.dto.ResultDTO;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.response.outinterface.gaode.weather.WeatherResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description： 服务降级
 * Author: ignore1992
 * Date: Created in 2019/1/5 19:48
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class OutInterfaceClientFallback implements OutInterfaceClient{
    @Override
    public ResultDTO<WeatherResponse> queryWeather(WeatherReqParam reqParam) {
        Map<String, Object> map = new HashMap<>(1);
        //失败状态
        map.put("status", 0);
        ObjectMapper mapper = new ObjectMapper();
        String kindlyRet = mapper.convertValue(map, JSONObject.class).toJSONString();
        WeatherResponse response = JSONObject.toJavaObject(JSON.parseObject(kindlyRet), WeatherResponse.class);
        return new ResultDTO<>(response);
    }
}
