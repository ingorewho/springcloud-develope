package com.ignore.scheduled.business.carepush.strategy.push;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description: 推送策略
 * @Date: Created In 9:59 2019/1/30
 */
public interface PushStrategy<E> {
    void push(List<E> datas);
}
