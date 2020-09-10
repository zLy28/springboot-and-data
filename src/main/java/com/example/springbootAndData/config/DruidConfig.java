package com.example.springbootAndData.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //等于在web.xml中配置servlet
    //Druid后台监控
    @Bean
    public ServletRegistrationBean druidMonitor() {
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("loginUsername", "admin");
        hashMap.put("loginPassword", "123");
        hashMap.put("allow", "");
        bean.setInitParameters(hashMap);

        return bean;
    }

    //也可以通过相同的方法设置filter
    public FilterRegistrationBean setFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        //写配置

        return bean;
    }
}
