package com.ignore.utils.ioc.config.db;

import com.ignore.utils.ioc.CommonContextAware;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description： 容器启动后处理db配置
 * Author: ignore1992
 * Date: Created in 2018/11/20 21:31
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class DbConfigIOCService implements ApplicationRunner{
    private Logger logger = LogManager.getLogger();

    @Autowired
    private CommonContextAware commonContextAware;
    @Autowired
    private DbConfigHandler dbConfigHandler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final ApplicationContext context = commonContextAware.getSelfApplicationContext();
        List<String> beanNames = dbConfigHandler.getBeanNames();
        if(CollectionUtils.isNotEmpty(beanNames)){
            List<Object> beans = beanNames.stream().map(name -> context.getBean(name)).collect(Collectors.toList());
            //处理这些bean
            dbConfigHandler.handle(beans);
        }
    }
}
