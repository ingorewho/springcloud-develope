package com.ignore.mail.controller;

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
        HttpEntity<String> entity = new HttpEntity<>("test");
        ResponseEntity<String> response = template.postForEntity(url , entity , String.class);
        logger.info("post请求结果:" + response.getBody());
    }
}
