package com.ignore.common.spring.listener;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author: ignore1992
 * @Description: 在Spring整个启动过程中，加入监听器，用于监控Spring启动流程
 *                要自己配置在META-INF/spring.factory的org.springframework.boot.SpringApplicationRunListener下
 * @Date: Created In 17:50 2018/12/13
 */
public class CommonRunListener implements SpringApplicationRunListener{
    @Override
    public void starting() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void finished(ConfigurableApplicationContext context , Throwable exception) {

    }
}
