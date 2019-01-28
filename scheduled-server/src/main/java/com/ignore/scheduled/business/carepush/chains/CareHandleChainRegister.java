package com.ignore.scheduled.business.carepush.chains;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ignore1992
 * @Description: 处理链注册器
 * @Date: 2019/1/27
 */
@Component
public class CareHandleChainRegister {
    private List<CareHandleChain> chains = Collections.synchronizedList(new ArrayList<>(16));

    /**
     * 注册处理链
     * @param chain
     */
    public void registChain(CareHandleChain chain){
        chains.add(chain);
    }

    /**
     * 反注册
     * @param chain
     */
    public void unRegistChain(CareHandleChain chain){
        if (chains.contains(chain)){
            chains.remove(chain);
        }
    }

    public List<CareHandleChain> getChains(){
        return chains;
    }
}
