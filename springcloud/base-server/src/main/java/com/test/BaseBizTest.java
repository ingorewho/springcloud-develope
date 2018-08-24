package com.test;

import com.spring.aop.BaseBizService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 17:59 2018/8/15
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseBizTest
{
	@Autowired
	private BaseBizService baseBizService;

	@Test
	public void test()
	{
		baseBizService.service();
	}
}
