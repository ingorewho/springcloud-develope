package com.ignore.common.frame.spring.properties.selector.register;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:33 2018/12/11
 */
public class CommonConfigPropertiesBindingPostProcessorRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata , BeanDefinitionRegistry registry) {

    }
}
