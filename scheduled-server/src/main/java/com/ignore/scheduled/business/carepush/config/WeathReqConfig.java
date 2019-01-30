package com.ignore.scheduled.business.carepush.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:18 2019/1/29
 */
@Component
@ConfigurationProperties(prefix = "carepush")
public class WeathReqConfig {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
