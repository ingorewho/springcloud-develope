package com.ignore.dblog.service;

import com.ignore.entity.common.dblog.DbLogEntity;

public interface DbLogService {
    public void writeLog(DbLogEntity dbLogEntity);
}
