package com.cos40003.bankaccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        CustomerAccount cus1 = new CustomerAccount ("Alan", 100.00f);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Simulate 5 deposit and 5 withdrawal transactions in 10 threads
        for (int i = 0; i < 5; i++) {
            executor.execute(new Thread(()->cus1.deposit(20)));
            executor.execute(new Thread(()->cus1.withdraw(40)));
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("Main thread end.");
    }

}
