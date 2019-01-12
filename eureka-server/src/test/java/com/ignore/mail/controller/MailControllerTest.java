package com.ignore.mail.controller;

import com.ignore.dto.mail.SimpleMailDTO;
import com.ignore.utils.common.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:14 2018/11/15
 */
public class MailControllerTest {
    private Logger logger = LogManager.getLogger();

    private String url;

    @BeforeTest
    public void beforeTest() {
        url = FileUtils.read("testng//mailUrl.txt");
    }

    @Test
    public void test() {
        RestTemplate template = new RestTemplate();
        SimpleMailDTO mailDTO = new SimpleMailDTO();
        mailDTO.setFromPos("17761256463@163.com");
        mailDTO.setToPos("17761256463@163.com");
        mailDTO.setContent("test");
        mailDTO.setSubject("test");
        HttpEntity<SimpleMailDTO> entity = new HttpEntity<SimpleMailDTO>(mailDTO);
        logger.info(url);
        ResponseEntity<Boolean> response = template.postForEntity(url , entity , Boolean.class);
        logger.info("post请求结果:" + response.getBody());
    }
}
