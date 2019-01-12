package com.ignore.soul.peom.controller;

import com.ignore.dto.ResultDTO;
import com.ignore.entity.soul.PeomEntity;
import com.ignore.soul.peom.service.PeomService;
import com.ignore.soul.peom.service.impl.PeomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:43 2019/1/11
 */
@RestController
@RequestMapping(value = "/peom")
public class PeomController {
    @Resource(name = "peomServiceImpl")
    private PeomService peomService;

    @GetMapping(value = "/get/byName/{peomName}")
    public ResultDTO<PeomEntity> getPeomByName(@PathVariable String peomName){
        return new ResultDTO<>(peomService.getPeomByName(peomName));
    }


}
