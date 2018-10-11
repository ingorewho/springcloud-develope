package com.spring.async.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: renzhiqiang-lhq
 * @Description: 异步方法无返回值情形下的异常处理
 * @Date: Created In 15:36 2018/8/20
 * @Modified By:
 */
@Configuration
@EnableAsync
public class AsyncHandlerService implements AsyncConfigurer
{
	Logger logger = LogManager.getLogger();

	@Bean
	@Override
	public Executor getAsyncExecutor()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(5);
		executor.setCorePoolSize(3);
		executor.setAllowCoreThreadTimeOut(true);
		executor.setKeepAliveSeconds(30);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setThreadGroupName("test-thread-");

		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
	{
		return new MyAsyncExceptionHandler();
	}

	class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler
	{
		@Override
		public void handleUncaughtException(Throwable throwable , Method method , Object... objects)
		{
			logger.error("处理异步方法异常{}", throwable.getMessage());
		}
	}
}
