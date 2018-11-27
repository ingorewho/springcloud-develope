package com.ignore.common.spring.ioc;

import com.ignore.common.spring.ioc.beans.BeanService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * Description： BeanDefinitionRegistryPostProcessor继承BeanFactoryPostProcessor接口
 *               可以实现在bean实例化前修改bean元数据的功能，也可以注册自己实例化的bean
 * Author: ignore1992
 * Date: Created in 2018/11/11 10:52
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Configuration
public class CommonRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] beanNameList = registry.getBeanDefinitionNames();
        //将自己创建的bean加入到Spring Bean注册表中，后面会实例化并自动放入容器中
        registerBean(registry, "testBean", new BeanService().getClass());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //可以在这里修改spring注册表已有的bean元配置数据
        try {
            BeanDefinition definition = beanFactory.getBeanDefinition("testBean");
        }catch (NoSuchBeanDefinitionException e){
            //测试
        }
    }

    private void registerBean(BeanDefinitionRegistry registry , String name , Class<?> beanClass) {

        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);

        //可以自动生成name
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(annotatedBeanDefinition , registry));

        //bean注册的holer类.
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition , beanName);

        //使用bean注册工具类进行注册.
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder , registry);

    }
}
