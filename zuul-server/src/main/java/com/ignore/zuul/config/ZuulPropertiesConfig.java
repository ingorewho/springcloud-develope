package com.ignore.zuul.config;

import com.ignore.common.frame.spring.factory.propertySource.CommonPropertySourceFactory;
import com.ignore.common.frame.spring.properties.annotation.CommonConfigProperties;
import lombok.Data;
import org.springframework.context.annotation.PropertySource;

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
