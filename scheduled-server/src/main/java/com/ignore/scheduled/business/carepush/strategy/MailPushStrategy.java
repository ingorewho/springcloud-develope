package com.ignore.scheduled.business.carepush.strategy;

import com.ignore.dto.mail.MailDTO;
import com.ignore.scheduled.client.MailServerClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: renzhiqiang-lhq
 * @Description: 邮箱推送策略
 * @Date: Created In 17:50 2019/1/28
 */
public class MailPushStrategy extends BasePushStrategy<MailDTO>{
    @Autowired
    private MailServerClient mailServerClient;

    @Override
    protected void push(MailDTO mailDTO) {
        mailServerClient.sendSimpleMail(mailDTO);
    }
}
