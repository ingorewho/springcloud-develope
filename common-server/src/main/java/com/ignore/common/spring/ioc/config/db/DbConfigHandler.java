package com.ignore.common.spring.ioc.config.db;

import com.ignore.common.client.QueryServerClient;
import com.ignore.entity.db.config.DbConfigEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private List<String> beanNames = new ArrayList<>();


    public void handle(List<Object> beans){
        if (CollectionUtils.isEmpty(beans)){
            logger.warn("加载到的beans为空");
            return;
        }
        logger.info("加载的beans数量:" + beans.size());
        List<DbConfigEntity> configs = null;
        try {
            QueryServerClient queryServerClient = DbConfigFeignClientUtils.getQueryServerClient();
            configs = queryServerClient.getAllConfigs().getData();
        }catch (Exception e){
            //发生Feign异常，打印异常然后return，考虑到query-server自己启动时会一直有问题，暂时未找到解决办法
            logger.error("获取query-server服务异常!");
            return;
        }
        if (CollectionUtils.isEmpty(configs)){
            Map<String, String> configMap = new HashMap<>(1024);
            configs.stream().forEach(config -> configMap.put(config.getKey(), config.getValue()));
            beans.parallelStream().forEach(aBean -> {
                Class<?> aClass = aBean.getClass().getSuperclass();
                Field[] aFieds = aClass.getFields();
                dealFields(aBean, aFieds, configMap);
            });
        }
    }

    private void dealFields(Object aBean, Field[] aFields, Map<String, String> configMap){
        for (Field aField : aFields){
            aField.setAccessible(true);
            DbConfigValue configValue = aField.getAnnotation(DbConfigValue.class);
            if (configValue.required()){
                String value = configMap.get(configValue.key());
                if (StringUtils.isNotBlank(value)){
                    try {
                        aField.set(aBean, value);
                    } catch (IllegalAccessException e) {
                        logger.error("解析注解配置失败!", e);
                    }
                }
            }
        }
    }

    public void setBeanNames(String name) {
        beanNames.add(name);
    }

    public List<String> getBeanNames() {
        return beanNames;
    }
}
