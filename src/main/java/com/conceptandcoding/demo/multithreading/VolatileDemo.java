package com.conceptandcoding.demo.multithreading;


public class VolatileDemo {
    public static void main(String[] args) {
        Shared shared=new Shared();
            Thread t1=new Thread(()->{
                
                    while(!shared.flag){
                        System.out.println("Thread is running: "+Thread.currentThread().getName());
                        
                        
                    }
                    System.out.println("Thread stopped");
                
            });
        t1.start();

        Thread t2=new Thread(


            ()->{
                try{
                Thread.sleep(1000);
                System.out.println("Thread is setting flag to true");
                }catch(InterruptedException e){
                    System.out.println("Thread interrupted "+e);
                }
                shared.flag=true;

            }
        );
        t2.start();
    }

}

class Shared{
    boolean flag=false;
}
