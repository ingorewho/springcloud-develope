package com.ignore.webservice.server.service.impl;

import com.ignore.webservice.server.service.WebServiceServer;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:40 2018/10/10
 */
public class WebServiceImpl implements WebServiceServer {
    @Override
    public String hello() {
        return "hello world";
    }
}
