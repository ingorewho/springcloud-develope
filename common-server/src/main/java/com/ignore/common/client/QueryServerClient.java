package com.ignore.common.client;

import com.ignore.common.client.fallback.QueryServerClientFallBack;
import com.ignore.cons.ServerConfigConst;
import com.ignore.entity.db.config.DbConfigEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Author: ignore1992
 * Date: Created in 2018/11/23 20:44
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@FeignClient(value = ServerConfigConst.QUERY_SERVER, fallback = QueryServerClientFallBack.class)
public interface QueryServerClient {

    @PostMapping("/dbconfig/query/all")
    List<DbConfigEntity> getAllConfigs();
}
