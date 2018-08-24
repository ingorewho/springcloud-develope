package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 17:23 2018/8/15
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
public class BaseApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(BaseApplication.class, args);
	}
}
