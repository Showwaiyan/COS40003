package com.cos40003.lab4_3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SomeClass extends Thread {
    private int[] a;
    private double ave;

    public SomeClass(int[] a) {

        this.a = a;
    }

    // Calculate the average of the array
    public void run() {
        String myName = Thread.currentThread().getName();
        System.out.println("Thread \"" + myName + "\" started.");
        System.out.println("Thread \"" + myName + "\" is calculating the average of");
        System.out.println(Arrays.toString(a));
        ave = IntStream.of(a).average().getAsDouble();
        System.out.println("Thread " + myName + " ended.");
    }

    public double getAverage() {
        return ave;
    }
}
