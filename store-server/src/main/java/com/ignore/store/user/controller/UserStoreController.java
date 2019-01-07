package com.ignore.store.user.controller;

import com.ignore.cons.ServerConfigConst;
import com.ignore.dto.ResultDTO;
import com.ignore.entity.store.user.UserEntity;
import com.ignore.store.user.service.UserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:01 2019/1/7
 */
@RestController
@RequestMapping(value = "/store")
public class UserStoreController {
    @Autowired
    private UserStoreService userStoreService;

    @PostMapping(value = "/user/insert")
    public ResultDTO<Integer> saveUser(@RequestBody List<UserEntity> users){
        return new ResultDTO<>(userStoreService.saveUser(users));
    }
}
