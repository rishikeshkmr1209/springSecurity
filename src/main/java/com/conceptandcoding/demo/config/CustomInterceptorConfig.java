package com.conceptandcoding.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.conceptandcoding.demo.interceptor.MyCustomInterceptor;

@Configuration
public class CustomInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyCustomInterceptor myCustomInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myCustomInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public/**"); // Intercept all API requests except public ones
    }

}
