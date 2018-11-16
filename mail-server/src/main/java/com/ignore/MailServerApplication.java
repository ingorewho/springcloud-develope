package com.ignore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * Description： 邮件服务入口
 * Author: ignore1992
 * Date: Created in 2018/11/10 15:34
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.ignore")
@ComponentScan("com.ignore")
@EnableAsync
public class MailServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailServerApplication.class , args);
    }
}
