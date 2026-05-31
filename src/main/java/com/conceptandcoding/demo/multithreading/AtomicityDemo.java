package com.conceptandcoding.demo.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                atomicInteger.incrementAndGet();   
            }
        }
        );
        t1.start();
        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                atomicInteger.incrementAndGet();
            }
        });                
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println("Thread interrupted "+e);
        }
        System.out.println("Final value of atomicInteger: "+atomicInteger.get());
    }
}
