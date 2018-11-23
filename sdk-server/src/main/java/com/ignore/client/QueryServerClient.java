package com.ignore.client;

import com.ignore.cons.ServerConfigConst;
import com.ignore.entity.db.config.DbConfigEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Author: ignore1992
 * Date: Created in 2018/11/23 20:44
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@FeignClient(ServerConfigConst.QUERY_SERVER)
public interface QueryServerClient {

    @PostMapping("/dbconfig/query/all")
    List<DbConfigEntity> getAllConfigs();
}
