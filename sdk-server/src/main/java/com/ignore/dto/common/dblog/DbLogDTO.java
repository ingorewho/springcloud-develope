package com.ignore.dto.common.dblog;

import lombok.Data;

/**
 * Description： 日志DTO（主要用来记录请求和响应结果）
 * Author: ignore1992
 * Date: Created in 2018/11/10 20:54
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
public class DbLogDTO {
    private String caller;
    private String args;
    private String response;
    private String bizId;
}
