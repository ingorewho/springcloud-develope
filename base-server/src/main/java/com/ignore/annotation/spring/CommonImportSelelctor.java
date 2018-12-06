package com.ignore.annotation.spring;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 17:40 2018/12/4
 */
class CommonImportSelelctor implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
