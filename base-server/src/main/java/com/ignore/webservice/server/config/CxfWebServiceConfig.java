package com.ignore.webservice.server.config;

import com.ignore.webservice.server.service.WebServiceServer;
import com.ignore.webservice.server.service.impl.WebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:41 2018/10/10
 */
@Configuration
public class CxfWebServiceConfig {
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet() , "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public WebServiceServer webServiceServer() {
        return new WebServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus() , webServiceServer());
        endpoint.publish("/api");
        return endpoint;
    }
}
