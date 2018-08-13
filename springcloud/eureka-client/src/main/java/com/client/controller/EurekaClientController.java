package com.client.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 20:45 2018/8/9
 * @Modified By:
 */
@RestController
public class EurekaClientController
{
	@PostMapping(value = "/hello")
	public String service(String json)
	{
		return "收到信息:" + json;
	}
}
