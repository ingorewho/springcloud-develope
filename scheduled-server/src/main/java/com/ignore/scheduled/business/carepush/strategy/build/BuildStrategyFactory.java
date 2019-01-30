package com.ignore.scheduled.business.carepush.strategy.build;

import com.google.common.collect.Maps;
import com.ignore.common.frame.spring.ioc.CommonContextAware;
import com.ignore.enumerate.ExceptionEnum;
import com.ignore.exception.strategy.PushStrategyException;
import com.ignore.scheduled.business.carepush.strategy.push.PushStrategy;
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
 * @Description: 构建策略工厂类
 * @Date: Created In 11:32 2019/1/30
 */
@Component
public class BuildStrategyFactory {
    @Autowired
    private CommonContextAware commonContextAware;
    /**策略列表.**/
    private static final Map<String, BuildStrategy> STRATEGY_MAP = Maps.newConcurrentMap();

    /**
     * 创建策略
     * @param strategy
     * @return
     */
    public BuildStrategy createStrategy(StrategyEnum strategy){
        Optional<BuildStrategy> optional = STRATEGY_MAP.
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
        throw new PushStrategyException("获取构建策略异常", ExceptionEnum.PUSH_STRATEGY_ERROR);
    }

    @PostConstruct
    private void init(){
        STRATEGY_MAP.putAll(commonContextAware.getSelfApplicationContext().getBeansOfType(BuildStrategy.class));
    }
}
