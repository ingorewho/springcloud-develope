package com.ignore.query.config.controller;

import com.ignore.entity.db.config.DbConfigEntity;
import com.ignore.query.config.service.impl.QueryConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:36 2018/11/21
 */
@RequestMapping("/dbconfig")
@RestController
public class QueryConfigController {
   @Autowired
   private QueryConfigServiceImpl queryConfigServiceImpl;

   @PostMapping("/query/all")
   public List<DbConfigEntity> getAllConfigs(){
      return queryConfigServiceImpl.getAllConfigs();
   }
}
