package com.ignore.common.frame.spring.properties.selector;

import com.ignore.common.frame.spring.properties.annotation.EnableCommonConfigProperties;
import com.ignore.common.frame.spring.properties.selector.register.CommonConfigPropertiesBindingPostProcessorRegistrar;
import com.ignore.common.frame.spring.properties.selector.register.CommonConfigPropertiesRegisterBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:20 2018/12/5
 */
public class CommonConfigPropertiesImportSelector implements ImportSelector{
    private  static Logger logger = LogManager.getLogger();
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(
                EnableCommonConfigProperties.class.getName(), false);
        Object[] type = attributes == null ? null
                : (Object[]) attributes.getFirst("classes");
        if (type == null || type.length == 0) {
            return new String[]{CommonConfigPropertiesBindingPostProcessorRegistrar.class.getName()};
        }
        //扫描EnableCommonConfigProperties注解中配置的类，如果类被ommonConfigProperties所注解，则加入容器，否则不处理
        return new String[]{
                CommonConfigPropertiesBindingPostProcessorRegistrar.class.getName(),
                CommonConfigPropertiesRegisterBean.class.getName()};
    }

}
