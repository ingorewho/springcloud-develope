package com.ignore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:29 2019/1/29
 */
@SpringBootApplication
@EnableScheduling
@EnableFeignClients("com.ignore")
public class SchedulerServerApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(SchedulerServerApplication.class, args);
    }
}
