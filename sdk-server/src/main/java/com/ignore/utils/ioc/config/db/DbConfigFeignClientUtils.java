package com.ignore.utils.ioc.config.db;

import com.ignore.client.QueryServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/23 20:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Component
public class DbConfigFeignClientUtils {
    private static QueryServerClient queryServerClient;

    public static QueryServerClient getQueryServerClient() {
        return queryServerClient;
    }



    @Autowired(required = false)
    public void setPath(QueryServerClient queryServerClient){
        DbConfigFeignClientUtils.queryServerClient = queryServerClient;
    }
}
