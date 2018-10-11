package com.spring.test;

import com.spring.async.service.CallAsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 15:16 2018/8/20
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AsyncTest
{
	@Autowired
	private CallAsyncService callAsyncService;

	@Test
	public void test()
	{
		String result = callAsyncService.callAsyncMethod();
		System.out.println(result);
	}
}
