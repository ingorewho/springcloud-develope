package com.ignore.store.user.service.impl;

import com.ignore.entity.store.user.UserEntity;
import com.ignore.store.user.dao.UserStoreDAO;
import com.ignore.store.user.service.UserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int saveUser(List<UserEntity> users) {
        //插入一条数据
        int result = userStoreDAO.save(users);
        return result;
    }
}
