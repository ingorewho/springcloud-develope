package com.ignore.common.dblog.service.impl;

import com.ignore.common.dblog.service.DbLogService;
import com.ignore.entity.common.dblog.DbLogEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Description： 保存日志实现类
 * Author: ignore1992
 * Date: Created in 2018/11/10 21:00
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class DbLogServiceImpl implements DbLogService {
    private Logger logger = LogManager.getLogger();

    @Override
    public void writeLog(DbLogEntity dbLogEntity) {
        logger.info("成功保存到数据库!");
    }
}
