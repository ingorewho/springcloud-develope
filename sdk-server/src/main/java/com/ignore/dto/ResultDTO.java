package com.ignore.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 10:27 2018/12/17
 */
public class ResultDTO<T extends Serializable> implements Serializable{
    private static final long serialVersionUID = -4258704169730505904L;

    /**
     * 返回码.
     */
    private int code;
    /**
     * 返回消息.
     */
    private String msg;
    /**
     * 返回数据.
     */
    private T data;

    /**
     * 无参构造器
     */
    public ResultDTO(){
    }

    /**
     * 有惨构造器
     * 参数:code，msg，data
     */
    public ResultDTO(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDTO(T  data){
        this.data = data;
    }

    public boolean emptyData(){
        return data == null
                || data instanceof String && StringUtils.isBlank((String)data)
                || data instanceof List && ((List)data).isEmpty()
                || data instanceof Map &&((Map)data).isEmpty()
                || data instanceof JSONObject && ((JSONObject)data).isEmpty()
                || data instanceof JSONArray && ((JSONArray)data).isEmpty();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
