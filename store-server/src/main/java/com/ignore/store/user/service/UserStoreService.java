package com.ignore.store.user.service;

import com.ignore.entity.store.user.UserEntity;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:03 2019/1/7
 */
public interface UserStoreService {
    int saveUser(List<UserEntity> users);
}
