package com.ignore.mail.send.dao;

import com.ignore.mail.send.entity.MailRecordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:30
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Mapper
public interface MailStoreDAO {
    int save(MailRecordEntity entity);
}
