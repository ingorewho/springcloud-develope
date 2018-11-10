package com.ignore.spring.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 14:59 2018/8/20
 * @Modified By:
 */
@Service
public class AsyncService
{
	/**
	 * 注：这里返回类型不能用AsyncResult类型，否则会抛异常
	 * @param param
	 * @return
	 */
	@Async
	public ListenableFuture<String> asyncMethod(String param)throws Exception
	{
		return new AsyncResult(param);
//		throw new Exception("ttt");
	}

	@Async
	public void asyncMehtodWithNoRet(String param)throws Exception
	{
		throw new Exception("ttt");
	}

}
