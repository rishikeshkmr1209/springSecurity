package com.conceptandcoding.demo.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {
    public static void main(String[] args) {

        ProducerConsumer consumer=new ProducerConsumer();

        Thread t1=new Thread(()->{
            for(int i=0;i<10;i++){
                try{
                consumer.produce(i);
                }catch(InterruptedException e){
                    System.out.println("Interrupted");
                }

            }
            
        });

         Thread t2=new Thread(()->{
            for(int i=0;i<10;i++){
                try{
                consumer.consume();
                }catch(InterruptedException e){
                    System.out.println("Interrupted");
                }

            }
            
        });
        t1.start();
        t2.start();

    }

}

class ProducerConsumer {
    final int capacity = 10;
    Queue<Integer> queue = new LinkedList<>();
    
   

    public synchronized void produce(int ele) throws InterruptedException {
        while (capacity == queue.size()) {
            System.out.println("Wait: " + Thread.currentThread().getName());
            wait();

        }
        queue.add(ele);
        System.out.println("Added element: " + ele);
        notifyAll();

    }
    public synchronized void consume() throws InterruptedException {

        while(queue.isEmpty()){
           wait();
        }
        System.out.println("Consumed element: "+queue.peek());
        queue.poll();
        notifyAll();
    }
}
