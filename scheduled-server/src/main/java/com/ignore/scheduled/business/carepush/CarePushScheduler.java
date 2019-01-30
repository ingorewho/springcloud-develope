package com.ignore.scheduled.business.carepush;

import com.ignore.scheduled.business.carepush.chains.CareHandleChain;
import com.ignore.scheduled.business.carepush.chains.CareHandleChainRegister;
import com.ignore.scheduled.business.carepush.config.CarePushConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description: 关怀推送
 * @Date: 2019/1/27
 */
@Component
public class CarePushScheduler {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private CareHandleChainRegister careHandleChainRegister;
    @Autowired
    private CarePushConfig carePushConfig;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void carePush(){
        logger.info("开始执行定时人文推送.");
        CareRequest request = carePushConfig.getCareReques();
        List<CareHandleChain> chains = careHandleChainRegister.getChains();
        for (int i = 0; i< chains.size(); i++){
            CareResult result = chains.get(i).pull(request);
            if (result != null){
                chains.get(i).push(result);
            }
        }
    }

}
