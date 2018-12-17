package com.ignore.common.spring.listener;

import com.ignore.common.spring.listener.event.CommonEvent;

/**
 * @Author: ignore1992
 * @Description: 根据spring监听器机制自实现一套监听器
 * @Date: Created In 11:41 2018/12/14
 */
public interface CommonEventMulticaster {
    void addCommonListener(CommonListener commonListener);

    void removeCommonListener(CommonListener commonListener);

    void multicastEvent(CommonEvent event);
}
