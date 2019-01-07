package com.ignore.query.config.service.impl;

import com.ignore.entity.db.config.DbConfigEntity;
import com.ignore.query.config.service.QueryConfigService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:32 2018/11/21
 */
@Service
public class QueryConfigServiceImpl implements QueryConfigService{
    @Override
    public List<DbConfigEntity> getAllConfigs() {
        return new ArrayList<DbConfigEntity>();
    }
}
