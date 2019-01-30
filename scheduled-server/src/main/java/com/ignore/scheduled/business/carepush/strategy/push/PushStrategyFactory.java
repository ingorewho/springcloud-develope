package com.ignore.scheduled.business.carepush.strategy.push;

import com.google.common.collect.Maps;
import com.ignore.common.frame.spring.ioc.CommonContextAware;
import com.ignore.enumerate.ExceptionEnum;
import com.ignore.exception.strategy.PushStrategyException;
import com.ignore.scheduled.business.carepush.strategy.StrategyAnnotation;
import com.ignore.scheduled.business.carepush.strategy.StrategyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: ignore1992
 * @Description: 推送策略工厂
 * @Date: Created In 9:58 2019/1/30
 */
@Component
public class PushStrategyFactory {
    @Autowired
    private CommonContextAware commonContextAware;
    /**策略列表.**/
    private static final Map<String, PushStrategy> STRATEGY_MAP = Maps.newConcurrentMap();

    /**
     * 创建策略
     * @param strategy
     * @return
     */
    public PushStrategy createStrategy(StrategyEnum strategy){
        Optional<PushStrategy> optional = STRATEGY_MAP.
                entrySet().
                stream().
                map(strategyInf -> {
                    StrategyAnnotation annotation = strategyInf.getValue().getClass().getAnnotation(StrategyAnnotation.class);
                    if (Objects.equals(annotation.strategy(), strategy)){
                        return strategyInf.getValue();
                    }
                    return null;
                }).filter(Objects::nonNull).findFirst();
        if (optional.isPresent()){
            return optional.get();
        }
        throw new PushStrategyException("获取推送策略异常", ExceptionEnum.PUSH_STRATEGY_ERROR);
    }

    @PostConstruct
    private void init(){
        STRATEGY_MAP.putAll(commonContextAware.getSelfApplicationContext().getBeansOfType(PushStrategy.class));
    }
}
