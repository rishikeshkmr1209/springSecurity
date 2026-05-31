package com.conceptandcoding.demo.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExampleDemo {
    int count=0;
    public static void main(String[] args) {
        LockExampleDemo demo=new LockExampleDemo();
         Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName());
                demo.increment();

            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName());
                demo.increment();

            }
        });
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){

        }
        System.out.println("Count: "+demo.count);
        

    }

    public void increment() {

        Lock l = new ReentrantLock();
        l.lock();
        try {
            count++;

        } finally {
            l.unlock();
        }
    }

}
