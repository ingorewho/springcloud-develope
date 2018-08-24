package com.spring.controller;

import com.spring.aop.BaseBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 10:02 2018/8/22
 * @Modified By:
 */
@RestController
public class BaseBizController
{
	@Autowired
	private BaseBizService baseBizService;
	@GetMapping(value = "service")
	public void service()
	{
		baseBizService.service();
	}
}
