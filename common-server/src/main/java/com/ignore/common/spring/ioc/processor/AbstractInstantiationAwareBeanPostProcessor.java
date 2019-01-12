package com.ignore.common.spring.ioc.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * @Author: ignore1992
 * @Description: 在spring-AbstractAutowireCapableBeanFactory创建bean时 优先执行InstantiationAwareBeanPostProcessor实现类集合，
 *                 创建一个代理对象作为bean
 * @Date: Created In 10:13 2018/12/19
 */
public abstract class AbstractInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass , String beanName) throws BeansException {
        //可以在这里自己实例化bean，或者不做任何操作，由spring-doCreatBean来创建bean
        //参考：AbstractAutowireCapableBeanFactory-createBean
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean , String beanName) throws BeansException {
        //实例化之后的操作，执行操作参考：AbstractAutowireCapableBeanFactory-populateBean
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs , PropertyDescriptor[] pds , Object bean , String beanName) throws BeansException {
        //在bean实例化之后修改bean的属性值，执行操作参考：AbstractAutowireCapableBeanFactory-populateBean
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean , String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean , String beanName) throws BeansException {
        return null;
    }
}
