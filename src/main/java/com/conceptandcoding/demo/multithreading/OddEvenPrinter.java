package com.conceptandcoding.demo.multithreading;

public class OddEvenPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer(10);
        Thread t1 = new Thread(() -> {
            printer.printOdd();
        });
        Thread t2 = new Thread(() -> {
            printer.printEven();
        });
        t1.start();
        t2.start();
    }

}
class Printer {
    private int limit;
    private int number = 1;

    public Printer(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (number < limit) {
            while (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Odd: " + number);
            number++;
            notify();
        }
    }

    public synchronized void printEven() {
        while (number < limit) {
            while (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Even: " + number);
            number++;
            notify();
        }
    }
}
