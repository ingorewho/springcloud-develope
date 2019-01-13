package com.ignore.common.frame.spring.ioc;

import com.ignore.common.frame.spring.ioc.processor.CommonBeanProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: ignore1992
 * @Description: 用于提供子类继承，实现在bean初始化前、后的操作
 * @Date: Created In 22:23 2018/11/27
 */
public abstract class CommonBeanPostProcessor implements BeanPostProcessor, CommonBeanProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean , String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException {
        return null;
    }

    @Override
    public void process() {

    }
}
