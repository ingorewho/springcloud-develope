package com.ignore.entity.db.config;

import lombok.Data;

import java.util.Date;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:37 2018/11/21
 */
@Data
public class DbConfigEntity {
    private String key;
    private String value;
    private Date createDate;
    private Date modifyDate;
}
