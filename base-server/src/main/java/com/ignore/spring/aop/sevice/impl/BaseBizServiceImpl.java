package com.ignore.spring.aop.sevice.impl;

import com.ignore.spring.aop.ClassAnnoation;
import com.ignore.spring.aop.LogOutput;
import com.ignore.spring.aop.sevice.BaseBizService;
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
@ClassAnnoation
public class BaseBizServiceImpl implements BaseBizService
{
	Logger logger = LogManager.getLogger();
	@Override
	@LogOutput("基本服务")
	public void service()
	{
		logger.info("执行基本业务.");
	}
}
