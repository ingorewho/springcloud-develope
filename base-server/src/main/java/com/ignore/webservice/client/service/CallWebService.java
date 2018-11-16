package com.ignore.webservice.client.service;

import com.ignore.webservice.dto.request.BaseReqDTO;
import com.ignore.webservice.dto.response.BaseResponseDTO;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 14:13 2018/10/10
 */
public interface CallWebService {

    BaseResponseDTO doCall(BaseReqDTO reqDTO);
}
