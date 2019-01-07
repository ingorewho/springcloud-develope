package com.ignore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:46 2019/1/7
 */
@SpringBootApplication
@ComponentScan("com.ignore")
public class StoreServerApplication {
    public static void main(String[] args){
        SpringApplication.run(StoreServerApplication.class, args);
    }
}
