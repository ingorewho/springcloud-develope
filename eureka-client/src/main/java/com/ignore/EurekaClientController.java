package com.ignore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 20:45 2018/8/9
 * @Modified By:
 */
@RestController
@RequestMapping(value = "eureka")
public class EurekaClientController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hello")
    public String service() {
        String result = restTemplate.getForEntity("http://hystrix-server/producer/service" , String.class).getBody();
        return result;
    }
}
