package com.ignore.webservice.test;

import com.ignore.webservice.dto.request.AxisReqDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:51 2018/10/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestAxisController {
    private MockMvc mock;

    private Logger logger = LogManager.getLogger();
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void before() {
        mock = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void test() {
        try {
            AxisReqDTO reqDTO = new AxisReqDTO();
            reqDTO.setNameSpace("");
            RequestBuilder request = post("/call/axis").param("data" , null).accept(MediaType.APPLICATION_JSON_UTF8);
            String res = mock.perform(request).andReturn().getResponse().getContentAsString();
            logger.info("请求axis接口，返回结果:{}" , res);
        } catch (Exception e) {
            logger.error("异常" , e);
        }
    }
}
