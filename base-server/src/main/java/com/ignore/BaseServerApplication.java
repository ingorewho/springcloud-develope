package com.ignore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 11:49 2018/10/10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAsync
public class BaseServerApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(BaseServerApplication.class, args);
    }
}
