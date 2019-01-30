package com.ignore.common.net.restful;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:09 2018/11/26
 */
@Component
public class CommonRestTemplate extends RestTemplate implements ApplicationListener<ApplicationReadyEvent>{
    @Value("${httpclient.timeout.connection:30}")
    private int connectTimeout;

    @Value("${httpclient.timeout.read:30}")
    private int readTimeout;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout * 1000);
        requestFactory.setReadTimeout(readTimeout * 1000);
        setRequestFactory(requestFactory);
    }
}
