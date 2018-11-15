package com.ignore.utils.aop.aspect.log.db.async;

import com.ignore.client.CommonServerClient;
import com.ignore.dto.common.dblog.DbLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/10 21:28
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Service
public class WriteDbLogServiceAsync {

    @Autowired(required = false)
    private CommonServerClient commonServerClient;
    @Autowired
    private ExecutorService executor;

    public void writeDbLog(DbLogDTO dbLogDTO){
        executor.execute(()->commonServerClient.writeDbLog(dbLogDTO));
    }
}
