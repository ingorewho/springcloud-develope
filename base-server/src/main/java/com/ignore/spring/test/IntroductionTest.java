package com.ignore.spring.test;

import com.ignore.spring.aop.sevice.BaseBizService;
import com.ignore.spring.aop.sevice.ExtendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 14:48 2018/9/26
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntroductionTest {
    @Autowired
    private BaseBizService baseBizService;

    @Test
    public void test() {
        ExtendService extendService = (ExtendService) baseBizService;
        extendService.extend();
    }
}
