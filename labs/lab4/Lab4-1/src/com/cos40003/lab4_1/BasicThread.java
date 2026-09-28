// This example shows how to create and use thread by using the Java Thread class
// Notice that the Main thread ended earlier than the others

package com.cos40003.lab4_1;

// Extend from Java Thread class
public class BasicThread extends Thread {
    // Thread object execute from run() method
    public void run() {
        System.out.println ("I am thread " + Thread.currentThread().getName() + " with id " + Thread.currentThread().getId());
        System.out.println(Thread.currentThread().toString());
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println ("Thread " + Thread.currentThread().getName() + " ended.");

    }

    public static void main(String[] args) {

        System.out.println("Main thread with id " + Thread.currentThread().getId());
        // Create a thread object with a name
        Thread t1 = new Thread(new BasicThread(),"Alpha");
        t1.start();		// and start them
        // Also create a thread object with default naming, and starting it
        new BasicThread().start();
        // Notice that if you call the run() method directly, a new thread will not be created.
        // The run() method will be executed in the Main thread instead.

        // print the info of the Main thread, including the thread's ID, name, priority, and thread group.
        System.out.println("Main thread : " + Thread.currentThread().toString());
        System.out.println ("Main thread ended.");

    }
}
