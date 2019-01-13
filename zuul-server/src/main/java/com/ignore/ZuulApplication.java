package com.ignore;

import com.ignore.common.frame.spring.properties.annotation.EnableCommonConfigProperties;
import com.ignore.zuul.config.ZuulPropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableCommonConfigProperties(classes ={ZuulPropertiesConfig.class})
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(new Object[] { ZuulApplication.class });
        application.run(args);
    }
}
