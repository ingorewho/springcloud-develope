package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:09 2018/9/3
 * @Modified By:
 */
@EnableEurekaClient
@SpringBootApplication
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class , args);
    }
}
