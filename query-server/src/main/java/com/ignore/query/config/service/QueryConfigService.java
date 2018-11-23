package com.ignore.query.config.service;

import com.ignore.entity.db.config.DbConfigEntity;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:31 2018/11/21
 */
public interface QueryConfigService {
    List<DbConfigEntity> getAllConfigs();
}
