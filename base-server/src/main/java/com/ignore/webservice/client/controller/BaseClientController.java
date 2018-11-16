package com.ignore.webservice.client.controller;

import com.ignore.webservice.client.service.CallWebService;
import com.ignore.webservice.dto.request.BaseReqDTO;
import com.ignore.webservice.dto.response.BaseResponseDTO;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:18 2018/10/10
 */
public abstract class BaseClientController {

    private CallWebService callWebService;

    /**
     * 模板方法
     *
     * @param reqDTO
     * @return
     */
    public BaseResponseDTO call(BaseReqDTO reqDTO) {
        return callWebService.doCall(reqDTO);
    }

    public void setCallWebService(CallWebService callWebService) {
        this.callWebService = callWebService;
    }
}
