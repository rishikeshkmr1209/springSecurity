package com.conceptandcoding.demo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conceptandcoding.demo.service.UserService;

import jakarta.annotation.PostConstruct;


@RestController
public class UserController {

    @Autowired
    UserService user;

    public UserController() {
        System.out.println("UserController1 instance created");
    }

    @PostConstruct
    public void init() {
        System.out.println("UserController1 PostConstruct method called: hashCode of UserController1 instance: "
                + this.hashCode() + " ,hashcode of User instance: " + user.hashCode());
    }

    @GetMapping("/hello")
    @Transactional(propagation = Propagation.REQUIRED)
    public String greetings() {

        System.out.println(
                "Is actual transaction active: " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());
        user.updateUserInfo();
        System.out.println("Some db operations performed in UserController1");
        return "Hello World";
    }

    @GetMapping("/asyncWithoutConfiguration")
    public String asyncWithoutConfiguration() {
        System.out.println(Thread.currentThread().getName() + " - Calling async method without configuration");
        user.displayUserInfo();
        return "Async method called without configuration";
    }

    @GetMapping("/asyncWithConfiguration")
    public String asyncWithConfiguration() {
        System.out.println(Thread.currentThread().getName() + " - Calling async method with configuration");
        user.displayUserInfo();
       // asyncInSameClass();
        return "Async method called with configuration";
    }

    @Async
    public void asyncInSameClass() { // Will not execute asynchronously due to self-invocation
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread: " + currentThread.getName());

    }

    
    @GetMapping("/asyncTransactionalCorrectWay")
    public void asyncTransacationalCorrectWay() { 
        user.transactionalInRepoClass();
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread: " + currentThread.getName());

    }

    @GetMapping("/asyncTransactionalWrongWay")
    public void asyncTransactionalWrongWay() { 
        System.out.println("Calling transactional method in UserRepository from UserController");
        user.wrongWayOfCallingAsyncAndTransactional();
         
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread: " + currentThread.getName());

    }

    @GetMapping("exceptionHandlingWithReturnType")
    public String exceptionHandlingWithReturnType() {
        try {
            // Some code that may throw an exception
           CompletableFuture<String> result = user.exceptionHandlingWithReturnType();
             result.get(); // This will block until the result is available
                return result.get(); // Return the result if successful
        } catch (Exception e) {
            System.out.println("Exception caught in UserController: " + e.getMessage());
            return "An error occurred";
        }
    }

    @GetMapping("exceptionHandlingWithoutReturnType1")
    public String exceptionHandlingWithoutReturnType1() {
       
            // Some code that may throw an exception
            user.exceptionHandlingWithoutReturnType1();
            return "Method executed successfully";
    }

     @GetMapping("exceptionHandlingWithoutReturnType2")
    public String exceptionHandlingWithoutReturnType2() {
       
            // Some code that may throw an exception
            user.exceptionHandlingWithoutReturnType2();
            return "Method executed successfully";
    }

}
 


