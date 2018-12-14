package com.ignore.holder.db;

import com.ignore.entity.db.config.DbConfigEntity;
import lombok.Data;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 13:42 2018/12/12
 */
@Data
public class DbConfigHolder {
    private DbConfigEntity dbConfigEntity;
    private String  configName;
}
