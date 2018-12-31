package com.ignore.mail.send.service.impl;

import com.ignore.dto.mail.MailDTO;
import com.ignore.enumerate.ExceptionEnum;
import com.ignore.exception.mail.MailException;
import com.ignore.mail.send.dao.MailStoreDAO;
import com.ignore.mail.send.entity.MailRecordEntity;
import com.ignore.mail.send.service.SendMailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public abstract class AbstractSendMailService<T extends MailDTO> implements SendMailService<T>{
    private Logger logger = LogManager.getLogger();
    @Autowired
    private MailStoreDAO mailStoreDAO;

    @Override
    public boolean sendMail(T mailDTO) {
        boolean result = false;
        try {
            send(mailDTO);
            //不发生异常认为发送成功
            result = true;
        }catch (Exception e){
            logger.error("发生邮件失败, 邮件信息:{}", mailDTO, e);
            throw new MailException("发送邮件失败!", ExceptionEnum.MAIL_SEND_ERROR);
        }finally {
            //记录发送邮件及结果到数据库
            MailRecordEntity recordEntity = transferRecord(mailDTO, result);
            mailStoreDAO.save(recordEntity);
        }
        return result;
    }

    /**
     * 发送邮件
     * @param mailDTO
     * @return
     */
    protected abstract void send(T mailDTO);

    /**
     * 转换邮件结果
     * @param mailDTO
     * @param result
     * @return
     */
    protected abstract MailRecordEntity transferRecord(T mailDTO, boolean result);
}
