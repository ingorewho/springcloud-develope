package com.ignore.common.cache.local.support.scheduler.impl;

import com.ignore.common.cache.local.support.scheduler.LocalCacheScheduler;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:43 2019/1/16
 */
public class RegularLocalCacheScheduler implements LocalCacheScheduler{

    @Override
    @Scheduled()
    public void clearTask() {

    }
}
