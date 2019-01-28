package com.ignore.scheduled.business.carepush.chains;


import com.ignore.scheduled.business.carepush.CareRequest;
import com.ignore.scheduled.business.carepush.CareResult;

/**
 * @Author: ignore1992
 * @Description: 针对关怀推送处理链接口
 * @Date: 2019/1/27
 */
public interface CareHandleChain<T> {
    CareResult pull(CareRequest<T> careRequest);

    boolean push(CareResult careResult);
}
