package com.ignore.zuul.config;

import com.ignore.common.spring.factory.propertySource.CommonPropertySourceFactory;
import com.ignore.common.spring.properties.annotation.CommonConfigProperties;
import com.ignore.common.spring.properties.annotation.EnableCommonConfigProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:50 2018/12/4
 */
//@ConfigurationProperties(prefix = "zuul", ignoreUnknownFields=true)
//@Component
@PropertySource(name="test",value = "classpath:common.properties", factory = CommonPropertySourceFactory.class)
@CommonConfigProperties(prefix = "common")
@Data
public class ZuulPropertiesConfig {
//    @Value("${routes.api.path}")
    private String path;
//    @Value("${routes.api.serviceId}")
    private String serviceId;
}
