package com.ignore.spring.test;

import com.ignore.spring.aop.sevice.impl.BaseBizServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:59 2018/8/15
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseBizTest {
    @Autowired
    private BaseBizServiceImpl baseBizService;

    @Test
    public void test() {
        baseBizService.service();
    }
}
