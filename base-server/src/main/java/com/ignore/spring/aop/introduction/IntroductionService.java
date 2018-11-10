package com.ignore.spring.aop.introduction;

import com.spring.aop.sevice.BaseBizService;
import com.spring.aop.sevice.ExtendService;
import com.spring.aop.sevice.impl.ExtendServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * 引入（Introduction）
 * 添加方法或字段到被通知的类。
 * @Date: Created In 14:35 2018/9/26
 */
@Aspect
@Component
public class IntroductionService {
    @Autowired
    @DeclareParents(value = "com.ignore.spring.aop.sevice.BaseBizService+", defaultImpl = ExtendServiceImpl.class)
    public ExtendService extendServiceImpl;

    
}
