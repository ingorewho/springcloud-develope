package com.ignore.store.user.service.impl;

import com.google.common.collect.Lists;
import com.ignore.entity.store.user.UserEntity;
import com.ignore.store.user.dao.UserStoreDAO;
import com.ignore.store.user.service.UserStoreService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:07 2019/1/7
 */
@Service
public class UserStoreServiceImpl implements UserStoreService{
    @Autowired
    private UserStoreDAO userStoreDAO;

    @Override
    public Integer saveUser(List<UserEntity> users) {
        //插入一条数据
        int result = userStoreDAO.save(users);
        return result;
    }

    @Override
    /**
     * 设置事务传播类型为REQUEST_NEW类型，设置事务隔离级别为RR级别，事务超时限制为30秒
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, timeout = 30)
    public Integer updateUser(UserEntity user) {
        int count = userStoreDAO.update(user);
        return count;
    }
}
