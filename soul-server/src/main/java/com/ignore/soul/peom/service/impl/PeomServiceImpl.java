package com.ignore.soul.peom.service.impl;

import com.ignore.entity.soul.PeomEntity;
import com.ignore.soul.peom.service.PeomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:56 2019/1/11
 */
@Service("peomServiceImpl")
public class PeomServiceImpl implements PeomService{
    private Logger logger = LogManager.getLogger();

    @Override
    public PeomEntity getPeomByName(String peomName) {
        //1.从二级缓存中(本地)取，二级缓存中没有从一级缓存中(分布式缓存)取

        //2.缓存中没有，则查询数据库

        //3.数据库没有，则查询外部接口，外部接口如果存在则插入数据库中并更新一级缓存

        //4.根据一级缓存中的命中数判断是否加入二级缓存

        return null;
    }
}
