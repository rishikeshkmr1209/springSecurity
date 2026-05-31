package com.conceptandcoding.demo.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        ExecutorService executor = Executors.newFixedThreadPool(2);
       
        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            
        });

    
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    int item = queue.take();
                    System.out.println("Consumed: " + item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();

}
}
