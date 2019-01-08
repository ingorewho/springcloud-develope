package com.ignore.store.user.dao;

import com.ignore.entity.store.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:13 2019/1/7
 */
@Mapper
public interface UserStoreDAO {
    Integer save(@Param("list") List<UserEntity> list);

    Integer update(UserEntity user);

    Integer updateByName(UserEntity user);

    Integer delete(UserEntity user);
}
