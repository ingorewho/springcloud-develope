package com.ignore.store.user;

import com.ignore.entity.store.user.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:27 2019/1/7
 */
public class UserStoreControllerTest {

    @Test
    public void save(){
        RestTemplate template = new RestTemplate();
        List<UserEntity> users = new ArrayList<>();
        UserEntity entity = new UserEntity();
        entity.setName("a");
        entity.setAge(8);
        entity.setUserId(4);
        users.add(entity);
        String url = "http://localhost:7009/store/user/update";
        ResponseEntity<Object> responseEntity = template.postForEntity(url, entity, Object.class);
        System.out.println(responseEntity.getBody());
    }
}
