package com.ignore.scheduled.business.carepush.strategy.build.impl;

import com.ignore.scheduled.business.carepush.CareResult;
import com.ignore.scheduled.business.carepush.strategy.build.BuildStrategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:26 2019/1/30
 */
public abstract class BaseBuildStrategy<P> implements BuildStrategy<P>{
    @Override
    public P build(CareResult careResult) {
        if (StringUtils.isBlank(careResult.getOption())){
            return null;
        }
        return build(careResult.getOption());
    }

    protected abstract P build(String data);
}
