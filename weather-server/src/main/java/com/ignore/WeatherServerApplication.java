package com.ignore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:22 2019/1/29
 */
@SpringBootApplication
@EnableFeignClients("com.ignore")
public class WeatherServerApplication {
    public static void main(String[] args){
        SpringApplication.run(WeatherServerApplication.class, args);
    }
}
