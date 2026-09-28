// This example shows how to force the main thread to wait for the child thread
// by using the join() method

package com.cos40003.lab4_3;

public class JoinThread {
    public static void main(String args[]) {

        int[] num = {10,20,30,40,50,60};
        System.out.println("Main thread: start");
        SomeClass sc = new SomeClass(num);
        // create thread t1 to execute the object sc
        Thread t1 = new Thread(sc, "Average Calculator");
        t1.start();

        /*
         The join() method blocks the main thread so that it will wait for thread t1 to complete
         If we remove the join(), the main thread will print out the average first before t1 thread
         finish calculating the average
        */

        try {
            t1.join();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        System.out.println("Main thread: The average is " + sc.getAverage());

        System.out.println("Main thread: end");
    }
}
