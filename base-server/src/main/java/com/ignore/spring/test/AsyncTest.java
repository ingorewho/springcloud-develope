package com.ignore.spring.test;

import com.ignore.spring.async.service.CallAsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:16 2018/8/20
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AsyncTest {
    @Autowired
    private CallAsyncService callAsyncService;

    @Test
    public void test() {
        String result = callAsyncService.callAsyncMethod();
        System.out.println(result);
    }
}
