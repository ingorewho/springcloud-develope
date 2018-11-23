package com.ignore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:06 2018/11/22
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.ignore")
@EnableFeignClients("com.ignore")
public class QueryServerApplication {
    public static void main(String[] args){
        SpringApplication.run(QueryServerApplication.class, args);
    }
}
