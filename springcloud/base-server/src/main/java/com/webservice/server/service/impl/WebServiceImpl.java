package com.webservice.server.service.impl;

import com.webservice.server.service.WebServiceServer;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 11:40 2018/10/10
 */
public class WebServiceImpl implements WebServiceServer{
    @Override
    public String hello() {
       return "hello world";
    }
}
