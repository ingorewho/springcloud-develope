package com.ignore.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 20:00 2018/8/9
 * @Modified By:
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
