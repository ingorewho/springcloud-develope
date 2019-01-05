package com.ignore.common.net.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Description： httpclient配置类
 * Author: ignore1992
 * Date: Created in 2019/1/5 17:29
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Configuration
public class HttpClientConfig {

    private volatile CloseableHttpClient httpClient = null;
    private Object monitor = new Object();

    // 连接池的最大连接数
    @Value("${httclient.max.connections:200}")
    private  int maxTotal;
    // 连接池按route配置的最大连接数
    @Value("${httclient.max.perroute:200}")
    private  int maxPerRoute;
    // tcp connect的超时时间
    @Value("${httclient.connection.timeout:500}")
    private  int connectTimeout;
    // 从连接池获取连接的超时时间
    @Value("${httclient.get.request.timeout:500}")
    private  int connectRequestTimeout;
    // tcp io的读写超时时间
    @Value("${httclient.socket.timeout:500}")
    private  int socketTimeout;

    public CloseableHttpClient getHttpClient(){
        //双重锁校验
        if (httpClient == null){
            synchronized (monitor){
                if (httpClient == null){
                    httpClient = initialize();
                }
            }
        }
        return httpClient;
    }

    private CloseableHttpClient  initialize(){
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();

        PoolingHttpClientConnectionManager gcm = new PoolingHttpClientConnectionManager(registry);
        gcm.setMaxTotal(this.maxTotal);
        gcm.setDefaultMaxPerRoute(this.maxPerRoute);

        // 设置连接超时
        // 设置读取超时
        // 设置从连接池获取连接实例的超时
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(this.connectTimeout)
                .setSocketTimeout(this.socketTimeout)
                .setConnectionRequestTimeout(this.connectRequestTimeout)
                .build();

        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        CloseableHttpClient httpClient = httpClientBuilder
                .setConnectionManager(gcm)
                .setDefaultRequestConfig(requestConfig)
                .build();
        return httpClient;
    }


}
