package com.ignore.druid.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 13:43 2018/11/22
 */
@Configuration
public class DruidMonitorConfig {
    @Value("${druid.login.username}")
    private String userName;
    @Value("${druid.login.password}")
    private String passWord;
    @Value("${druid.allow.ips}")
    private String allowIps;
    @Value("${druid.deny.ips}")
    private String denyIps;

    @Bean
    public ServletRegistrationBean registrationBean() {
        //添加初始化参数：initParams
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet());
        //白名单：
        servletRegistrationBean.addInitParameter("allow", allowIps);
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", denyIps);
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", userName);
        servletRegistrationBean.addInitParameter("loginPassword", passWord);
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        //慢查询
        servletRegistrationBean.addInitParameter("logSlowSql", "true");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
