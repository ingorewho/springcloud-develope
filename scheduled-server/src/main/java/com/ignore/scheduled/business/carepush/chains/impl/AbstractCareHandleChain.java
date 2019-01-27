package com.ignore.scheduled.business.carepush.chains.impl;

import com.ignore.scheduled.business.carepush.CareRequest;
import com.ignore.scheduled.business.carepush.CareResult;
import com.ignore.scheduled.business.carepush.chains.CareHandleChain;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ignore1992
 * @Description: 处理链抽象类
 * @Date: 2019/1/27
 */
public abstract class AbstractCareHandleChain<T> implements CareHandleChain<T>{
    protected String careType;

    public AbstractCareHandleChain(String careType){
        this.careType = careType;
    }

    @Override
    public CareResult handle(CareRequest<T> careRequest) {
        //检查careType是否对应的上
        if (careRequest != null && StringUtils.isNotBlank(careType) && careType.equals(this.careType)){
            CareResult result = new CareResult();
            result.setCareType(careType);
            result.setOption(handle(careRequest.getData()));
            return result;
        }else {
            return null;
        }
    }

    /**
     * 根据请求数据获取人文提示
     * @param data
     * @return
     */
    protected abstract String handle(T data);
}
