package com.ignore.dto.mail;

import lombok.Data;

import java.io.Serializable;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:07
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
public class SimpleMailDTO extends MailDTO implements Serializable{
    private static final long serialVersionUID = -3640305250893538785L;
    private String content;

    @Override
    public String toString() {
        return "SimpleMailDTO{" +
                "content='" + content + '\'' +
                ", fromPos='" + fromPos + '\'' +
                ", toPos='" + toPos + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
