package com.ignore.webservice.client.service;

import com.ignore.webservice.dto.response.BaseResponseDTO;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:56 2018/10/10
 */
public abstract class AbstractCallWebService implements CallWebService {
    /**
     * 转化请求结果
     *
     * @return 请求结果
     */
    abstract protected BaseResponseDTO transferResponse(Object result);
}
