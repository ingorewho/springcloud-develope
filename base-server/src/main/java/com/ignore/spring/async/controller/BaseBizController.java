package com.ignore.spring.async.controller;

import com.ignore.spring.aop.sevice.impl.BaseBizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:02 2018/8/22
 * @Modified By:
 */
@RestController
public class BaseBizController {
    @Autowired
    private BaseBizServiceImpl baseBizService;

    @GetMapping(value = "service")
    public void service() {
        baseBizService.service();
    }
}
