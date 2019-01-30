package com.ignore.scheduled.client.fallback;

import com.ignore.dto.mail.AttachMailDTO;
import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.scheduled.client.MailServerClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:56 2019/1/28
 */
@Component
public class MailServerClientFallback implements MailServerClient{
    private Logger logger = LogManager.getLogger();
    @Override
    public boolean sendSimpleMail(SimpleMailDTO mailDTO) {
        logger.warn("发送简单邮件走降级逻辑.");
        return false;
    }

    @Override
    public boolean sendAttachMail(AttachMailDTO mailDTO) {
        logger.warn("发送附件邮件走降级逻辑.");
        return false;
    }
}
