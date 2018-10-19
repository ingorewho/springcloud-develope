package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 15:07 2018/8/14
 * @Modified By:
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigApplication.class, args);
	}
}
