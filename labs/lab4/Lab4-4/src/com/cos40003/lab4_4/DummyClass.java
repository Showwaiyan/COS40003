package com.cos40003.lab4_4;

public class DummyClass implements Runnable {

    public void run() {
        for(int i = 1; i <= 10_000_000; i++) {
            //dummy operation
            int a = i+1;

        }

        System.out.println(Thread.currentThread().getName() + " --> ended.");
    }
}
