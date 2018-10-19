package com.spring.test;

import com.spring.aop.sevice.BaseBizService;
import com.spring.aop.sevice.ExtendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: renzhiqiang-lhq
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
    public void test()
    {
        ExtendService extendService =(ExtendService) baseBizService;
        extendService.extend();
    }
}
