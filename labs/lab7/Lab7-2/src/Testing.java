// This example demonstrates how to implement a simple lock class by
// using AtomicBoolean (Boolean value that is accessed atomically)

public class Testing {

    public static void main(String[] args) {

        SharedData data = new SharedData(0);    // Shared data between the threads
        SimpleLock lock = new SimpleLock();     // our simple lock
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                //lock.acquire();                 // acquire the lock before access to shared data
                data.increment();
                //lock.release();                 // release the lock after finish
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                //lock.acquire();
                data.decrement();
                //lock.release();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread " + data.getData());

    }
}
