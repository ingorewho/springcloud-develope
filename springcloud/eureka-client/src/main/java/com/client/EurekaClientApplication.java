package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 20:44 2018/8/9
 * @Modified By:
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
