package com.ignore.common.frame.spring.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: 常见场景：在执行finishRefresh时Spring会发出ignore1992类型事件
 * @Date: Created In 17:42 2018/12/13
 */
@Component
public class CommonContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{
    private Logger logger = LogManager.getLogger();
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //保证只接受子容器的context刷新事件，
        //经测试：Springboot启动过程中，虽然父子容器都会发布ignore1992事件，但是
        //由于通过@Component方式自定义的监听器，只会在执行子容器的finishBeanFactoryInitialization方法时才会实例化，所以只会接受到子容器的事件
        if (event.getApplicationContext().getParent() != null){
            logger.info("事件刷新:{}", event.getApplicationContext());
        }
    }
}
