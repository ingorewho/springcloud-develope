package com.ignore.mail.send.service.impl;

import com.ignore.dto.mail.AttachMailDTO;
import com.ignore.mail.send.entity.MailRecordEntity;
import org.springframework.stereotype.Service;

/**
 * @Author: ignore1992
 * @Description: 暂未实现
 * @Date: Created In 14:55 2019/1/29
 */
@Service
public class SendAttachMailServiceImpl extends AbstractSendMailService<AttachMailDTO>{
    @Override
    protected void send(AttachMailDTO mailDTO) {

    }

    @Override
    protected MailRecordEntity transferRecord(AttachMailDTO mailDTO , boolean result) {
        return null;
    }
}
