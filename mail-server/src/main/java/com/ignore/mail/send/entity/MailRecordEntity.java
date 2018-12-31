package com.ignore.mail.send.entity;

import lombok.Data;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:31
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
public class MailRecordEntity {
    /**
     * 邮件记录id
     */
    private long id;
    /**
     * 来源地址
     */
    private String fromPos;
    /**
     * 目的地址
     */
    private String toPos;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 发送结果:true:成功/false:失败
     */
    private boolean sendResult;
}
