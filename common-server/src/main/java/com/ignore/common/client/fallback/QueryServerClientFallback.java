package com.ignore.common.client.fallback;

import com.ignore.common.client.QueryServerClient;
import com.ignore.dto.ResultDTO;
import com.ignore.entity.db.config.DbConfigEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ignore1992
 * @Description: QueryServerClient的服务降级逻辑
 * @Date: Created In 10:07 2018/11/26
 */
public class QueryServerClientFallback implements QueryServerClient{
    private Logger logger = LogManager.getLogger();
    @Override
    public ResultDTO<ArrayList<DbConfigEntity>> getAllConfigs() {
        logger.error("查询db配置信息失败，返回空集合!");
        List<DbConfigEntity> configs = new ArrayList<>();
        return null;
    }
}
