package com.webservice.client.controller;

import com.webservice.client.service.CallWebService;
import com.webservice.dto.request.BaseReqDTO;
import com.webservice.dto.response.BaseResponseDTO;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:18 2018/10/10
 */
public abstract class BaseClientController {

    private CallWebService callWebService;

    /**
     * 模板方法
     * @param reqDTO
     * @return
     */
    public BaseResponseDTO call(BaseReqDTO reqDTO){
        return callWebService.doCall(reqDTO);
    }

    public void setCallWebService(CallWebService callWebService) {
        this.callWebService = callWebService;
    }
}
