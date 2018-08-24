package com.spring.aop;

import lombok.extern.java.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 17:57 2018/8/15
 * @Modified By:
 */
@Component
public class BaseBizService
{
	Logger logger = LogManager.getLogger();
	@LogOutput("基本服务")
	public void service()
	{
		logger.info("执行基本业务.");
	}
}
