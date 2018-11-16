package com.ignore.json.alibaba.entity;

import lombok.Data;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 19:28 2018/9/18
 * @Modified By:
 */
@Data
public class Animal {
    private String request;
    private String result;

    public Animal(String request , String result) {
        this.request = request;
        this.result = result;
    }

    public String getString() {
        return String.format("Person[request:%s, result:%s]" , request , result);
    }
}
