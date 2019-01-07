package com.ignore.store.user.dao;

import com.ignore.entity.store.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:13 2019/1/7
 */
@Mapper
public interface UserStoreDAO {
    int save(List<UserEntity> users);

    int update(UserEntity user);

    int updateByName(UserEntity user);

    int delete(UserEntity user);
}
