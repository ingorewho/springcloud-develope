package com.ignore.scheduled.business.carepush.chains.impl;

import com.google.common.collect.Lists;
import com.ignore.enumerate.ExceptionEnum;
import com.ignore.scheduled.business.carepush.CareEnum;
import com.ignore.scheduled.business.carepush.CareRequest;
import com.ignore.scheduled.business.carepush.CareResult;
import com.ignore.scheduled.business.carepush.chains.CareHandleChain;
import com.ignore.scheduled.business.carepush.strategy.build.BuildStrategy;
import com.ignore.scheduled.business.carepush.strategy.build.BuildStrategyFactory;
import com.ignore.scheduled.business.carepush.strategy.push.PushStrategy;
import com.ignore.scheduled.business.carepush.strategy.StrategyEnum;
import com.ignore.scheduled.business.carepush.strategy.push.PushStrategyFactory;
import com.ignore.scheduled.business.carepush.strategy.push.impl.MailPushStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ignore1992
 * @Description: 处理链抽象类
 * @Date: 2019/1/27
 */
public abstract class AbstractCareHandleChain<T> implements CareHandleChain<T>{
    protected Logger logger = LogManager.getLogger();
    protected CareEnum careType;
    protected String strategyName;

    @Autowired
    private BuildStrategyFactory buildStrategyFactory;
    @Autowired
    private PushStrategyFactory pushStrategyFactory;

    public AbstractCareHandleChain(CareEnum careType){
        this.careType = careType;
    }

    @Override
    public CareResult pull(CareRequest<T> careRequest) {
        //检查careType是否对应的上
        if (careRequest != null && careType.equals(this.careType)){
            try {
                CareResult result = new CareResult();
                result.setCareType(careType);
                result.setOption(handle(careRequest.getData()));
                return result;
            }catch (Exception e){
                logger.error("拉取数据失败!", e);
                return null;
            }
        }else {
            logger.warn("请求数据为空! 参数:{}", careRequest);
            return null;
        }
    }

    @Override
    public boolean push(CareResult careResult) {
        try {
            BuildStrategy buildStrategy = buildStrategyFactory.createStrategy(StrategyEnum.getStrategy(strategyName));
            PushStrategy pushStrategy = pushStrategyFactory.createStrategy(StrategyEnum.getStrategy(strategyName));
            pushStrategy.push(Lists.newArrayList(buildStrategy.build(careResult)));
        }catch (Exception e){
            logger.error("推送失败!", e);
            return false;
        }
        return true;
    }

    /**
     * 根据请求数据获取人文提示
     * @param data
     * @return
     */
    protected abstract String handle(T data);
}
