package com.ignore.common.frame.spring.ioc.config.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/23 21:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Component
public class DbConfigPostAwareAdpter extends InstantiationAwareBeanPostProcessorAdapter{
    private Logger logger = LogManager.getLogger();
    private static final String PREFIX_BEAN_NAME = "com.ignore";

    @Autowired
    private DbConfigHandler dbConfigHandler;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getName().contains("TestBean")){
            logger.error("初始化TestBean");
        }
        if (bean.getClass().getName().startsWith(PREFIX_BEAN_NAME)){
            logger.info("初始化完需要的bean后置操作, beanName={}", beanName);
            dbConfigHandler.setBeanNames(beanName);
        }
        return bean;
    }
}
