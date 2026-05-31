package com.conceptandcoding.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.conceptandcoding.demo.MyCustomFilter1;
import com.conceptandcoding.demo.MyCustomFilter2;

@Configuration
public class MyCustomFilterConfig {


    @Bean
    public FilterRegistrationBean registerFilter1() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyCustomFilter1());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);
        System.out.println("Registering MyCustomFilter1");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean registerFilter2() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyCustomFilter2());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);
        System.out.println("Registering MyCustomFilter2");
        return registrationBean;
    }   

}
