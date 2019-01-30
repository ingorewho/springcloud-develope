package com.ignore.scheduled.client;

import com.ignore.common.frame.spring.aop.log.OutputLog;
import com.ignore.cons.ServerConfigConst;
import com.ignore.dto.mail.AttachMailDTO;
import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.scheduled.client.fallback.MailServerClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: ignore1992
 * @Description: 邮箱服务客户端
 * @Date: Created In 17:52 2019/1/28
 */
@FeignClient(value = ServerConfigConst.MAIL_SERVER, fallback = MailServerClientFallback.class)
public interface MailServerClient {
    @PostMapping("/send/simple")
    boolean sendSimpleMail(@RequestBody SimpleMailDTO mailDTO);

    @PostMapping("/send/attach")
    boolean sendAttachMail(@RequestBody AttachMailDTO mailDTO);
}
