package com.ignore.scheduled.business.carepush.strategy.build;

import com.ignore.scheduled.business.carepush.CareResult;

/**
 * @Author: ignore1992
 * @Description: 构建推送实体信息
 * @Date: Created In 11:24 2019/1/30
 */
public interface BuildStrategy<P> {
    P build(CareResult careResult);
}
