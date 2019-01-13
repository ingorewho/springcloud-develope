package com.ignore.common.frame.spring.factory.propertySource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description: 自定义PropertySourceFactory
 * @Date: Created In 14:04 2018/12/12
 */
public class CommonPropertySourceFactory implements PropertySourceFactory {
    private Logger logger = LogManager.getLogger();
    @Override
    public PropertySource<?> createPropertySource(String name , EncodedResource resource) throws IOException {
        logger.info("加载自定义配置文件:{}", name);
        return (name != null ? new ResourcePropertySource(name, resource) : new ResourcePropertySource(resource));
    }
}
