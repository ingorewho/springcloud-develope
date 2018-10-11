package com.webservice.test;

import com.webservice.dto.request.AxisReqDTO;
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
 * @Author: renzhiqiang-lhq
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
    public void before(){
        mock = MockMvcBuilders.webAppContextSetup(wac).build();

        ((((!((((主险.riskCode.equals(com.sinosoft.brms.product.RiskCode.codeAADD06))
                && (policy.sellType.equals(com.sinosoft.brms.policy.SellType.code2A)))))
                && 风险.riskvalue in {"FL", "FA"})) && (((险种.riskCode !in ) && (被保人.applyAge.intValue() in [18, 35]) && (被保人.accumLifeAndAccidRiskAmount.doubleValue() > 被保人.yearIncome.doubleValue() * 20)))))
    }

    险种.riskCode !in {com.sinosoft.brms.product.RiskCode.codeALSE, com.sinosoft.brms.product.RiskCode.codeALSB}) && (被保人.occupationCode !in {com.sinosoft.brms.insurant.OccupationName.code1701003, com.sinosoft.brms.insurant.OccupationName.code1201003, com.sinosoft.brms.insurant.OccupationName.code6071203, com.sinosoft.brms.insurant.OccupationName.code4099908, com.sinosoft.brms.insurant.OccupationName.code4099907, com.sinosoft.brms.insurant.OccupationName.code1603024, com.sinosoft.brms.insurant.OccupationName.code5000001}



    ((((((((险种.ruleCheck.equals("EL"))
            && (既往保单.appFlag.equals(com.sinosoft.brms.custHistPolicy.AppFlag.code1)))
            && (既往保单.custType.equals(com.sinosoft.brms.custHistPolicy.CustType.code1)))
            && (既往险种.ruleCheck.equals("EL")))
            && 既往险种.uwflag !in {com.sinosoft.brms.histProduct.UWFlag.code1, com.sinosoft.brms.histProduct.UWFlag.code2, com.sinosoft.brms.histProduct.UWFlag.codea})
            && 既往险种.appFlag in {com.sinosoft.brms.histProduct.AppFlag.code0, com.sinosoft.brms.histProduct.AppFlag.code1, com.sinosoft.brms.histProduct.AppFlag.code9})
            && !(((险种.riskCode in {com.sinosoft.brms.product.RiskCode.codeAHRF, com.sinosoft.brms.product.RiskCode.codeAHRG}
         	&& ((policy.prtNo.startsWith("100598")) || (policy.prtNo.startsWith("100599")) || (policy.prtNo.startsWith("100689")) || (policy.prtNo.startsWith("100688"))))))))







    @Test
    public void test(){
        try{
            AxisReqDTO reqDTO = new AxisReqDTO();
            reqDTO.setNameSpace("");
            RequestBuilder request = post("/call/axis").param("data", null).accept(MediaType.APPLICATION_JSON_UTF8);
            String res = mock.perform(request).andReturn().getResponse().getContentAsString();
            logger.info("请求axis接口，返回结果:{}", res);
        }catch (Exception e)
        {
            logger.error("异常", e);
        }
    }
}
