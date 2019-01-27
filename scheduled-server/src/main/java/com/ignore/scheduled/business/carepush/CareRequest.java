package com.ignore.scheduled.business.carepush;

import lombok.Data;

/**
 * @Author: ignore1992
 * @Description: 请求者
 * @Date: 2019/1/27
 */
@Data
public class CareRequest<T> {
    /**类型.**/
    private String careType;
    /**请求数据.**/
    private T data;
}
