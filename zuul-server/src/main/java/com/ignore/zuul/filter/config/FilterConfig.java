package com.ignore.zuul.filter.config;

import com.ignore.zuul.filter.CommonFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/13 21:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Configuration
public class FilterConfig {

    @Bean
    public CommonFilter commonFilter() {
        return new CommonFilter();
    }
}
