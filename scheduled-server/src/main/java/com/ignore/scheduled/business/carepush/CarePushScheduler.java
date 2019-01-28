package com.ignore.scheduled.business.carepush;

import com.ignore.scheduled.business.carepush.chains.CareHandleChain;
import com.ignore.scheduled.business.carepush.chains.CareHandleChainRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description: 关怀推送
 * @Date: 2019/1/27
 */
public class CarePushScheduler {
    @Autowired
    private CareHandleChainRegister careHandleChainRegister;


    @Scheduled(cron = "0 5 * * * *")
    protected void carePush(){
        CareRequest request = pull();
        List<CareHandleChain> chains = careHandleChainRegister.getChains();
        for (int i = 0; i< chains.size(); i++){
            CareResult result = chains.get(i).pull(request);
            if (result != null){
                //根据不同策略推送人文关怀信息

            }
        }
    }

    protected CareRequest pull(){
        return null;
    }
}
