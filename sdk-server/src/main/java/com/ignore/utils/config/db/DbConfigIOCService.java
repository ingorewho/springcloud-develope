package com.ignore.utils.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description： 容器启动后执行一些操作
 * Author: ignore1992
 * Date: Created in 2018/11/20 21:31
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class DbConfigIOCService implements ApplicationRunner{
    private static final String PREFIX_BEAN_NAME = "com.ignore";

    @Autowired
    private CommonContextAware commonContextAware;
    @Autowired
    private DbConfigHandler dbConfigHandler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ApplicationContext context = commonContextAware.getSelfApplicationContext();
        String[] beanNames = context.getBeanDefinitionNames();
        List<Object> beans = new ArrayList<>();
        if (beanNames.length != 0){
            for (String beanName : beanNames){
                if (beanName.startsWith(PREFIX_BEAN_NAME)){
                    //将以com.ignore开头的bean定义加入集合中，以便后面对这些bean进行处理
                    beans.add(context.getBean(beanName));
                }
            }
        }
        //处理这些bean
        dbConfigHandler.handle(beans);
    }
}
