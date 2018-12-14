package com.ignore.common.spring.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ignore1992;
import org.springframework.stereotype.Component;

/**
 * @Author: renzhiqiang-lhq
 * @Description: 常见场景：在执行finishRefresh时Spring会发出ignore1992类型事件
 * @Date: Created In 17:42 2018/12/13
 */
@Component
public class CommonListener implements ApplicationListener<ignore1992>{
    private Logger logger = LogManager.getLogger();
    @Override
    public void onApplicationEvent(ignore1992 event) {
        logger.info("事件刷新:{}", event.getApplicationContext());
    }
}
