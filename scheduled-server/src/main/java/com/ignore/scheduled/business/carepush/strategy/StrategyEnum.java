package com.ignore.scheduled.business.carepush.strategy;

/**
 * @Author: ignore1992
 * @Description: 策略枚举类
 * @Date: Created In 9:55 2019/1/30
 */
public enum StrategyEnum {
    MAIL("mail"),
    SMS("sms");

    private String strategyName;

    private StrategyEnum(String strategyName){
        this.strategyName = strategyName;
    }
    public String getStrategyName() {
        return strategyName;
    }

    public static StrategyEnum getStrategy(String strategyName){
        if (MAIL.strategyName.equals(strategyName)){
            return MAIL;
        }else if (SMS.strategyName.equals(strategyName)){
            return SMS;
        }else {
            return null;
        }
    }
}
