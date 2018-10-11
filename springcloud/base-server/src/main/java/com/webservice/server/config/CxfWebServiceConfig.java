package com.webservice.server.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.webservice.server.service.WebServiceServer;
import com.webservice.server.service.impl.WebServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 11:41 2018/10/10
 */
@Configuration
public class CxfWebServiceConfig {
    @Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    @Bean
    public WebServiceServer webServiceServer(){
        return new WebServiceImpl();
    }

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(springBus(), webServiceServer());
        endpoint.publish("/api");
        return endpoint;
    }
}
