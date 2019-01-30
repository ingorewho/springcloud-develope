package com.ignore.dto.mail;

import lombok.Data;

import java.io.File;
import java.io.Serializable;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:10
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
public class AttachMailDTO extends MailDTO implements Serializable{
    private static final long serialVersionUID = 7320151298197680648L;
    private File attachFile;

    @Override
    public String toString() {
        return "AttachMailDTO{" +
                "attachFile=" + attachFile +
                ", fromPos='" + fromPos + '\'' +
                ", toPos='" + toPos + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
