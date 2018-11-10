package com.ignore.server.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:53 2018/9/3
 * @Modified By:
 */
@Service
public class ProduceService
{
	@HystrixCommand(fallbackMethod = "serviceFallBack")
	public String service()
	{
		return "hello";
	}

	public String serviceFallBack()
	{
		return "请求异常.";
	}
}
