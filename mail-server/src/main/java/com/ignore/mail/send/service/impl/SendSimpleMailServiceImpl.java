package com.ignore.mail.send.service.impl;

import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.mail.send.entity.MailRecordEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author: ignore1992
 * @Description: 发送简单内容邮件
 * @Date: Created In 17:14 2018/11/16
 */
@Service
public class SendSimpleMailServiceImpl extends AbstractSendMailService<SimpleMailDTO> {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private JavaMailSender mailSender;

    @Override
    protected void send(SimpleMailDTO mailDTO) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailDTO.getFromPos());
        //可添加多个目的地址
        msg.setTo(mailDTO.getToPos());
        msg.setSubject(mailDTO.getSubject());
        msg.setText(mailDTO.getContent());
        logger.info("开始发送简单邮件..");
        mailSender.send(msg);
    }

    @Override
    protected MailRecordEntity transferRecord(SimpleMailDTO mailDTO, boolean result) {
        MailRecordEntity entity = new MailRecordEntity();
        entity.setFromPos(mailDTO.getFromPos());
        entity.setToPos(mailDTO.getToPos());
        entity.setContent(mailDTO.getContent());
        entity.setSendResult(result);
        return entity;
    }
}
