package com.ignore.spring.aop.sevice.impl;

import com.ignore.spring.aop.sevice.ExtendService;
import org.springframework.stereotype.Component;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 14:37 2018/9/26
 * @Modified By:
 */
@Component
public class ExtendServiceImpl implements ExtendService {
    @Override
    public void extend() {
        System.out.println("调用扩展接口方法.");
    }
}
