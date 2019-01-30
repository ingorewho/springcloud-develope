package com.ignore.scheduled.business.carepush.strategy.push.impl;

import com.ignore.dto.mail.AttachMailDTO;
import com.ignore.dto.mail.MailDTO;
import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.scheduled.business.carepush.strategy.StrategyAnnotation;
import com.ignore.scheduled.business.carepush.strategy.StrategyEnum;
import com.ignore.scheduled.client.MailServerClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: 邮箱推送策略
 * @Date: Created In 17:50 2019/1/28
 */
@Component
@StrategyAnnotation(strategy = StrategyEnum.MAIL)
public class MailPushStrategy extends BasePushStrategy<MailDTO>{
    private Logger logger = LogManager.getLogger();

    @Autowired
    private MailServerClient mailServerClient;

    @Override
    protected void push(MailDTO mailDTO) {
        //这里默认只发送简单邮件
        if (mailDTO instanceof SimpleMailDTO){
            mailServerClient.sendSimpleMail((SimpleMailDTO) mailDTO);
        }else if(mailDTO instanceof AttachMailDTO){
            mailServerClient.sendAttachMail((AttachMailDTO)mailDTO);
        }else {
            logger.warn("邮件类型错误,不能发送!");
        }
    }
}
