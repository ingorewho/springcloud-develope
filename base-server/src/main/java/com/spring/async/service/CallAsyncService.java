package com.spring.async.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 15:11 2018/8/20
 * @Modified By:
 */
@Service
@EnableAsync
public class CallAsyncService
{
	@Autowired
	private AsyncService asyncService;

	public String callAsyncMethod()
	{
		try
		{
			asyncService.asyncMehtodWithNoRet("hello");
			ListenableFuture<String> result =  asyncService.asyncMethod("hello");
			return result.get();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
