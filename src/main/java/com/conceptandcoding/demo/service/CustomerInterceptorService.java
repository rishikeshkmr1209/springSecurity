package com.conceptandcoding.demo.service;

import org.springframework.stereotype.Service;

import com.conceptandcoding.demo.model.MyCustomAnnotation;

@Service
public class CustomerInterceptorService {

    @MyCustomAnnotation(value = 5, name = "Custom Service")
    public void performService() {
        System.out.println("Inside performService method of CustomerInterceptorService");
    }

}
