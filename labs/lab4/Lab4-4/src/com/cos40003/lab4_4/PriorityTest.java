// This example shows the effect of thread's priority
// You can only notice the effect if you run on 1 CPU
package com.cos40003.lab4_4;

import java.io.IOException;

public class PriorityTest {
    public static void main(String args[]) throws InterruptedException {

        System.out.println("Main thread started");
        System.out.println("Press a key to start creating threads");
        try {

            // Read a single byte from the input stream, pausing execution
            System.in.read();
        } catch (IOException e) {
            // Handle any potential IOException during input reading
            e.printStackTrace();
        }
        // Create a thread object with a name
        Thread t1 = new Thread(new DummyClass(),"First Thread");
        Thread t2 = new Thread(new DummyClass(),"Second Thread");
        Thread t3 = new Thread(new DummyClass(),"Third Thread");
        // Set the priority of the thread. The priority value range from 1 (lowest) to 10 (highest)
        // The default priority is 5
        t1.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        // Notice that the priority value is just programmer's preference. The OS scheduler may
        // or may not follow depending on the scheduling algorithm and other factors.
        t1.start();
        t2.start();
        t3.start();
        System.out.println ("Main thread ended.");



    }

}

