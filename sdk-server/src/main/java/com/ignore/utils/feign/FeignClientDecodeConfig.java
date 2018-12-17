package com.ignore.utils.feign;

import com.alibaba.fastjson.JSON;
import com.ignore.dto.ResultDTO;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 12:44 2018/12/17
 */
@Configuration
public class FeignClientDecodeConfig implements Decoder{
    @Override
    public Object decode(Response response , Type type) throws IOException, DecodeException, FeignException {
        if (response.body() == null) {
            return null;
        }
        String body = feign.Util.toString(response.body().asReader());
        Object obj = null;
        try {
            obj = JSON.parseObject(body, type);
        } catch (Exception e) {
            if(String.class.equals(type)){
                return body;
            }
            obj = JSON.parseObject(body, ResultDTO.class);
        }

        if (obj instanceof ResultDTO) {
            ResultDTO dto = (ResultDTO) obj;
            return dto;
        }
        return obj;
    }
}
