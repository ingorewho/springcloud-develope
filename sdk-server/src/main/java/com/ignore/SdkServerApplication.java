package com.ignore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description： sdk服务
 * Author: ignore1992
 * Date: Created in 2018/11/10 19:07
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@SpringBootApplication
@EnableEurekaClient
public class SdkServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SdkServerApplication.class , args);
    }
}
