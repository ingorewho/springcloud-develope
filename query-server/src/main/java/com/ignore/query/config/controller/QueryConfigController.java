package com.ignore.query.config.controller;

import com.ignore.dto.ResultDTO;
import com.ignore.entity.db.config.DbConfigEntity;
import com.ignore.query.config.service.impl.QueryConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:36 2018/11/21
 */
@RestController
@RequestMapping(value = "/dbconfig")
public class QueryConfigController {
   @Autowired
   private QueryConfigServiceImpl queryConfigServiceImpl;

   @GetMapping(value = "/query/all")
   public ResultDTO<ArrayList<DbConfigEntity>> getAllConfigs(){
      return new ResultDTO<ArrayList<DbConfigEntity>>(queryConfigServiceImpl.getAllConfigs());
   }
}
