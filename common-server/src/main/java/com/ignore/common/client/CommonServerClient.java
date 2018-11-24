package com.ignore.common.client;

import com.ignore.cons.ServerConfigConst;
import com.ignore.dto.common.dblog.DbLogDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/10 21:17
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@FeignClient(ServerConfigConst.COMMON_SERVER)
public interface CommonServerClient {

    @PostMapping("/common/dblog/write")
    void writeDbLog(@RequestBody DbLogDTO dbLogDTO);
}
