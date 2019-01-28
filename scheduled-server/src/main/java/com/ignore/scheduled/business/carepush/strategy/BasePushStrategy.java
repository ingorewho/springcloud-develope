package com.ignore.scheduled.business.carepush.strategy;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @Author: renzhiqiang-lhq
 * @Description: 推送策略抽象类
 * @Date: Created In 17:35 2019/1/28
 */
public abstract class BasePushStrategy<E> {
    private Logger logger = LogManager.getLogger();

    public void push(List<E> datas){
        if (CollectionUtils.isEmpty(datas)){
            logger.warn("数据为空,不能推送");
            return;
        }
        datas.parallelStream().forEach(e -> push(e));
    }

    protected abstract void push(E e);
}
