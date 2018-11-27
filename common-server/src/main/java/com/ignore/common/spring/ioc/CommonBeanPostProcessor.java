package com.ignore.common.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 22:23 2018/11/27
 */
public abstract class CommonBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean , String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException {
        return null;
    }
}
