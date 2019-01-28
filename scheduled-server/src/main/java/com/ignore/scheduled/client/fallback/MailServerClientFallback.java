package com.ignore.scheduled.client.fallback;

import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.scheduled.client.MailServerClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 17:56 2019/1/28
 */
@Component
public class MailServerClientFallback implements MailServerClient{
    private Logger logger = LogManager.getLogger();
    @Override
    public boolean sendSimpleMail(SimpleMailDTO mailDTO) {
        logger.warn("发送邮件走降级逻辑.");
        return false;
    }
}
