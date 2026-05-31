package com.conceptandcoding.demo.concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            
             return new RuntimeException("Something went wrong!");
        }).thenAccept(result -> {
            System.out.println("Result: " + result);
           
        }).exceptionally(ex -> {
            System.err.println("Error: " + ex.getMessage());
            return null;
        });
    }

}
