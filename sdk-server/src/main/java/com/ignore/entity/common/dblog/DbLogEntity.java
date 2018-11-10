package com.ignore.entity.common.dblog;

import lombok.Data;

/**
 * Description： dblog entity
 * Author: ignore1992
 * Date: Created in 2018/11/10 21:02
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
public class DbLogEntity {
    private String caller;
    private String args;
    private String response;
    private String bizId;
}
