package com.conceptandcoding.demo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        /* ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown(); */

       /*  ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            singleThreadExecutor.submit(() -> {
                System.out.println("Single Thread Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            }); 
        } 
        singleThreadExecutor.shutdown();*/
        /* ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            fixedThreadPool.submit(() -> {
                System.out.println("Fixed Thread Pool Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            }); 
        }
        fixedThreadPool.shutdown(); */
        ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            scheduledExecutor.submit(() -> {
                System.out.println("Scheduled Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            });
        }
            scheduledExecutor.shutdown();
            

    }

}
