package com.webservice.client.service;

import com.webservice.dto.request.BaseReqDTO;
import com.webservice.dto.response.BaseResponseDTO;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 14:13 2018/10/10
 */
public interface CallWebService {

    BaseResponseDTO doCall(BaseReqDTO reqDTO);
}
