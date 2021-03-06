package com.ignore.log.dblog.controller;

import com.ignore.dto.common.dblog.DbLogDTO;
import com.ignore.entity.common.dblog.DbLogEntity;
import com.ignore.log.dblog.service.impl.DbLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description： db写日志入口
 * Author: ignore1992
 * Date: Created in 2018/11/10 20:51
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@RestController
public class DbLogController {

    @Autowired
    private DbLogServiceImpl dbLogServiceImpl;

    @PostMapping("/common/dblog/write")
    public void write(@RequestBody DbLogDTO dbLogDTO) {
        DbLogEntity entity = new DbLogEntity();
        entity.setBizId(dbLogDTO.getBizId());
        dbLogServiceImpl.writeLog(entity);
    }
}
