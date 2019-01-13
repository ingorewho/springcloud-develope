package com.ignore.common.frame.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.core.PriorityOrdered;

import java.util.HashSet;
import java.util.Set;

/**
 * 提供一个模板
 * Description： BeanDefinitionRegistryPostProcessor继承BeanFactoryPostProcessor接口
 *               可以实现在bean实例化前修改bean元数据的功能，也可以注册自己实例化的bean
 * Author: ignore1992
 * Date: Created in 2018/11/11 10:52
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public abstract class CommonRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor,PriorityOrdered {
    private final Set<Integer> registriesPostProcessed = new HashSet<Integer>();

    private final Set<Integer> factoriesPostProcessed = new HashSet<Integer>();

    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    private String beanName;
    private Class<?> clazz;

    public CommonRegistryPostProcessor(String beanName, Class<?> clazz){
        this.beanName = beanName;
        this.clazz = clazz;
    }

    @Override
    public int getOrder() {
        //设置优先级为中
        return 0;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int registryId = System.identityHashCode(registry);
        if (this.registriesPostProcessed.contains(registryId)) {
            throw new IllegalStateException(
                    "postProcessBeanDefinitionRegistry already called on this post-register against " + registry);
        }
        if (this.factoriesPostProcessed.contains(registryId)) {
            throw new IllegalStateException(
                    "postProcessBeanFactory already called on this post-register against " + registry);
        }
        this.registriesPostProcessed.add(registryId);

        //将自己创建的bean加入到Spring Bean注册表中，后面会实例化并自动放入容器中
        registerBean(registry, beanName, clazz);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        //可以在这里修改spring注册表已有的bean元配置数据

    }

    protected void registerBean(BeanDefinitionRegistry registry , String name , Class<?> beanClass) {

        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);

        //可以自动生成name
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(annotatedBeanDefinition , registry));

        //bean注册的holer类.
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition , beanName);

        //使用bean注册工具类进行注册.
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder , registry);

    }
}
