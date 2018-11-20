package com.ignore.utils.config.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/20 21:20
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Component
public class DbConfigHandler{
    private Logger logger = LogManager.getLogger();

    public void handle(List<Object> beans){
        if (CollectionUtils.isEmpty(beans)){
            logger.warn("加载到的bean为空");
        }

        beans.parallelStream().forEach(aBean -> {
            Class<?> aClass = aBean.getClass().getSuperclass();
            DbConfigValue configValue = aClass.getAnnotation(DbConfigValue.class);
            Field[] aFieds = aClass.getFields();
            

        });
    }

}
