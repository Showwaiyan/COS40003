package com.cos40003.bankaccount;

import java.util.concurrent.locks.ReentrantLock;

public class CustomerAccount {
    private String customerName;
    private float balance;
    private ReentrantLock lock = new ReentrantLock();


    public CustomerAccount(String name, float balance) {
        this.customerName = name;
        this.balance = balance;
        System.out.println("Account " + name + " has been created with balance of $" + balance);
    }

    /*
    // Implementation using synchronized method
    public synchronized void deposit (float amount) {
        float currentBalance = balance;
        balance = balance + amount;

        System.out.println("[Deposit ] : Starting balance is $" + currentBalance + "\t+$" + amount + "\t New balance = $" + balance);

    }

    public synchronized void  withdraw (float amount) {

        if (balance < amount) {
            System.out.println("[Withdraw] : Insufficient balance ! Can't withdraw $" + amount
                        + " from balance of $" + balance);
        } else {
            float currentBalance = balance;
            balance = balance - amount;
            System.out.println("[Withdraw] : Starting balance is $" + currentBalance + "\t-$" + amount + "\t New Balance = $" + balance);
        }

    }
    */

    // Implementation using normal Lock (ReentrantLock)
    public void deposit (float amount) {
        lock.lock();
        try {
            float currentBalance = balance;
            balance = balance + amount;

            System.out.println("[Deposit ] : Starting balance is $" + currentBalance + "\t+$" + amount + "\t New balance = $" + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw (float amount) {
        lock.lock();
        try {
            if (balance < amount) {
                System.out.println("[Withdraw] : Insufficient balance ! Can't withdraw $" + amount
                            + " from balance of $" + balance);
            } else {
                float currentBalance = balance;
                balance = balance - amount;
                System.out.println("[Withdraw] : Starting balance is $" + currentBalance + "\t-$" + amount + "\t New Balance = $" + balance);
            }
        } finally {
            lock.unlock();
        }
    }


}
