package com.conceptandcoding.demo.multithreading;

public class ThreadCreation {
    public static void main(String[] args) {
        
        Runnable runnable=new MyRunnable();
        Thread t1=new Thread(runnable);
        t1.setName("CustomThread-1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setDaemon(true);
        
        t1.start();
        t1.run(); // this will run in the main thread and not in a new thread

        Thread t2=new Thread(()->{
            System.out.println("This is a thread created using lambda expression");
            System.out.println("Thread name: "+Thread.currentThread().getName());
        });
        t2.start();

        //any other way to create a thread is by extending the Thread class and overriding the run method
        Thread t3=new Thread(){
            @Override
            public void run(){
                System.out.println("This is a thread created by extending the Thread class");   
                System.out.println("Thread name: "+Thread.currentThread().getName());
            }
        };
        t3.start();

        MyThread t4=new MyThread();
        t4.start();
        
    }

}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running");
        System.out.println("Thread name: "+Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread is running");
        System.out.println("Thread name: "+Thread.currentThread().getName());
    }
}

