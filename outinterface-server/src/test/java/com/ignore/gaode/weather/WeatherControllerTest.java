package com.ignore.gaode.weather;

import com.ignore.dto.ResultDTO;
import com.ignore.parameter.outinterface.gaode.WeatherReqParam;
import com.ignore.response.outinterface.gaode.weather.WeatherResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2019/1/5 18:40
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public class WeatherControllerTest {
    private Logger logger = LogManager.getLogger();

    private String url;

    @BeforeTest
    public void beforeTest() {
        url = "http://localhost:7008/weather/query";
    }

    @Test
    public void test() {
        RestTemplate template = new RestTemplate();
        WeatherReqParam reqParam = new WeatherReqParam();
        reqParam.setCity("510100");
        HttpEntity<WeatherReqParam> entity = new HttpEntity<WeatherReqParam>(reqParam);
        logger.info(url);
        ResponseEntity<String> response = template.postForEntity(url , entity , String.class);
        logger.info("post请求结果:" + response.getBody());
    }
}
