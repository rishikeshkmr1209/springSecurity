package com.conceptandcoding.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import com.conceptandcoding.demo.repo.UserRepository;

@Component
public class UserService {
    @Value("${user.name}")
    private String name;
    @Value("${user.password}")
    private String password;

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        System.out.println("UserService instance created");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateUserInfo() {

        System.out.println(
                "Is actual transaction active: " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Some db operations performed in User");
        System.out.println("User info updated: name = " + this.name + ", password = " + this.password);
    }

    // @Async("anotherTaskExecutor")
    @Async
    public void displayUserInfo() {
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread: " + currentThread.getName());

    }

    @Async
    public void transactionalInRepoClass() {
        System.out.println("Calling transactional method in UserRepository from UserService");
        userRepository.saveUser();
    }

    @Async
    @Transactional
    public void wrongWayOfCallingAsyncAndTransactional() {
        System.out.println("Calling transactional method in UserRepository from UserService");
        
    }

    public CompletableFuture<String> exceptionHandlingWithReturnType() {

        CompletableFuture<String> future = new CompletableFuture<>();
        future.completeExceptionally(new RuntimeException("An error occurred in exceptionHandling1"));
        return future;
    }

    @Async
    public void exceptionHandlingWithoutReturnType1() {
        try{
            int x=0/0;
            System.out.println("Result: " + x);
        } catch (Exception e) {
            System.out.println("Exception caught in UserService: " + e.getMessage());
        }
    }

     @Async
    public void exceptionHandlingWithoutReturnType2() {
            int x=0/0;
            
    }

}
