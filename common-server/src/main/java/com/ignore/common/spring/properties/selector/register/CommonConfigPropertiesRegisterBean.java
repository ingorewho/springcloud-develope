package com.ignore.common.spring.properties.selector.register;

import com.ignore.common.spring.properties.annotation.CommonConfigProperties;
import com.ignore.common.spring.properties.annotation.EnableCommonConfigProperties;
import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:48 2018/12/11
 */
public class CommonConfigPropertiesRegisterBean implements ImportBeanDefinitionRegistrar {
    private  static Logger logger = LogManager.getLogger();

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        MultiValueMap<String, Object> attributes = metadata
                .getAllAnnotationAttributes(
                        EnableCommonConfigProperties.class.getName(), false);
        List<Class<?>> types = collectClasses(attributes.get("classes"));
        for (Class<?> type : types) {
            String prefix = extractPrefix(type);
            String name = (StringUtils.hasText(prefix) ? prefix + "-" + type.getName()
                    : type.getName());
            if (!registry.containsBeanDefinition(name)) {
                registerBeanDefinition(registry, type, name);
            }
        }
    }

    private String extractPrefix(Class<?> type) {
        CommonConfigProperties annotation = AnnotationUtils.findAnnotation(type,
                CommonConfigProperties.class);
        if (annotation != null) {
            return annotation.prefix();
        }
        return "";
    }

    private List<Class<?>> collectClasses(List<Object> list) {
        ArrayList<Class<?>> result = new ArrayList<Class<?>>();
        for (Object object : list) {
            for (Object value : (Object[]) object) {
                if (value instanceof Class && value != void.class) {
                    result.add((Class<?>) value);
                }
            }
        }
        return result;
    }

    private void registerBeanDefinition(BeanDefinitionRegistry registry,
                                        Class<?> type, String name) {
        CommonConfigProperties properties = AnnotationUtils.findAnnotation(type,
                CommonConfigProperties.class);
        if (properties == null){
            logger.error("没有发现'{}注解'在类:{}上，不加入spring容器中", CombinedConfiguration.class.getSimpleName(), type.getName());
        }else {
            logger.info("将{}类注册到spring容器注册表", type.getName());
            BeanDefinitionBuilder builder = BeanDefinitionBuilder
                    .genericBeanDefinition(type);
            AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
            registry.registerBeanDefinition(name, beanDefinition);
        }
    }
}
