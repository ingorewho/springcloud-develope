package com.webservice.client.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.webservice.dto.request.AxisReqDTO;
import com.webservice.dto.response.AxisRepsDTO;
import com.webservice.dto.response.BaseResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renzhiqiang-lhq
 * @Description: axis请求webservice入口类
 * @Date: Created In 16:18 2018/10/10
 */
@RestController
public class AxisClientController extends BaseClientController{

    @PostMapping(value = "/call/axis")
    public BaseResponseDTO callAxis(@RequestBody String data){
        JSONObject jsonObject = JSON.parseObject(data);
        AxisReqDTO axisReqDTO = jsonObject.toJavaObject(AxisReqDTO.class);
        return call(axisReqDTO);
    }
}
