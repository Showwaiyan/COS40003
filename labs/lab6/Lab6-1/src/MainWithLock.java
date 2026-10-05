// In this program, we use the ReentrantLock class to create a lock
// Each thread need to acquire the lock before access to the shared resources - taskCount
// This is to ensure that only 1 thread could increase taskCount at a time

import java.util.concurrent.locks.ReentrantLock;

public class MainWithLock {
    public static void main(String[] args) throws InterruptedException {

        TaskCounter taskCount = new TaskCounter();
        ReentrantLock lock = new ReentrantLock();
        // generate 1000 tasks to be executed by 1000 threads
        for (int i=0; i<1000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is running and completing a task");
                doSomeWork();
                lock.lock();    // acquire the lock
                try {
                    taskCount.incCount();
                } finally {
                    lock.unlock();  // release the lock
                }

            }).start();

        }
        // A small delay to make sure all threads are completed before
        // we proceed to print the final count
        Thread.sleep(1000);

        System.out.println("Total tasks completed = " + taskCount.getCount());
    }

    private static void doSomeWork() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}