package com.conceptandcoding.demo.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockProductionGradeExample {

    public static void main(String[] args) {
        Account account1 = new Account("Account1", 1000);
        Account account2 = new Account("Account2", 2000);

        TransferService transferService = new TransferService();

        Thread t1 = new Thread(() -> {
            try {
                transferService.transfer(account1, account2, 500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted " + e);
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                transferService.transfer(account2, account1, 300);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted " + e);
            }
        });
        t2.start();
    }

}

class TransferService {

    public void transfer(Account from, Account to, double amount) throws InterruptedException {
        boolean fromLock = false;
        boolean toLock = false;

        try {
            fromLock = from.getLock().tryLock(1, TimeUnit.SECONDS);
            toLock = from.getLock().tryLock(1, TimeUnit.SECONDS);
            if (fromLock && toLock) {

                from.withdraw(amount);
                to.deposit(amount);

            } else {
                System.out.println("Not able to transfer the money");
            }

        } catch (InterruptedException e) {
            System.out.println("Interrupted " + e);

        } finally {

            if (fromLock) {
                from.getLock().unlock();
            }
            if (toLock) {
                to.getLock().unlock();
            }

        }

    }
}

class Account {

    Lock lock = new ReentrantLock();
    String name;
    double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

}