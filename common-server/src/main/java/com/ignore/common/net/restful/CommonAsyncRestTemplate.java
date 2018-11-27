package com.ignore.common.net.restful;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 12:38 2018/11/26
 */
@Component
public class CommonAsyncRestTemplate extends AsyncRestTemplate implements ApplicationListener<ApplicationReadyEvent>{

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    }
}
