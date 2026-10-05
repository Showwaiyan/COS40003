// This example illustrate the use of ReentrantReadWriteLock, which separate a lock to
// read_lock and write_lock. It allows multiple threads to acquire the read_lock at the same
// time but only allows one thread to acquire the write_lock at a time

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {

    public static void main(String[] args) {

        SharedData data = new SharedData(99);
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                lock.readLock().lock();     // acquire readLock
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + "[" + LocalTime.now() + "] : read " + data.readData() + " from shared data");
                lock.readLock().unlock();

            }, "Reader-" + i).start();
        }

        // Create three writer threads
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                final int newData = new Random().nextInt(100,200);
                lock.writeLock().lock();    // acquire writeLock

                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                data.writeData(newData);
                System.out.println(Thread.currentThread().getName() + "[" + LocalTime.now() + "] : write " + newData + " to shared data");
                lock.writeLock().unlock();


            }, "Writer-" + i).start();
        }


    }
}
