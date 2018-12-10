package com.ignore.common.spring.ioc.processor;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:42 2018/11/29
 */
public interface CommonBeanDefinitionRegistry extends BeanDefinitionRegistry {
    void registCommon(List<?> commonInfos);
}
