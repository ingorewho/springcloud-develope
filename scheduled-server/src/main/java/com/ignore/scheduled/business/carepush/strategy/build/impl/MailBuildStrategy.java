package com.ignore.scheduled.business.carepush.strategy.build.impl;

import com.ignore.dto.mail.MailDTO;
import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.scheduled.business.carepush.strategy.StrategyAnnotation;
import com.ignore.scheduled.business.carepush.strategy.StrategyEnum;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: 构建邮件实体
 * @Date: Created In 11:28 2019/1/30
 */
@Component
@StrategyAnnotation(strategy = StrategyEnum.MAIL)
public class MailBuildStrategy extends BaseBuildStrategy<MailDTO>{
    @Override
    protected MailDTO build(String data) {
        //先写个简单例子
        SimpleMailDTO mailDTO = new SimpleMailDTO();
        mailDTO.setFromPos("2388891412@qq.com");
        mailDTO.setToPos("2388891412@qq.com");
        mailDTO.setContent(data);
        mailDTO.setSubject("test");
        return mailDTO;
    }
}
