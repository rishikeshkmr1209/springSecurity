package com.conceptandcoding.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conceptandcoding.demo.service.CustomerInterceptorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class CustomInterceptorController {
    @Autowired
    private CustomerInterceptorService customerInterceptorService;

    @GetMapping("/getUser")
    public String getUser(@RequestParam String name) {
        System.out.println("Inside getUser method of CustomInterceptorController");
        customerInterceptorService.performService();
        return "Welcome: " + name;
    }
    
  

}
