package com.ignore.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Description： 公共服务入口
 * Author: ignore1992
 * Date: Created in 2018/11/10 20:50
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CommonServerApplication {
    public static void main(String[] args){
        SpringApplication.run(CommonServerApplication.class, args);
    }
}
