// Spin-waiting or Busy-waiting lock implementation
// using "CompareAndSwap" mechanism

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleLock {
    static AtomicLong accumulatedSpinWaitTime = new AtomicLong(0);
    private AtomicBoolean flag = new AtomicBoolean();
    public SimpleLock() {
        // set the flag to false initially
        flag.set(false);
        // false = lock available, true = lock is taken
    }

    public void lock() {
        // Compare the current flag value: if it is false, set it to true
        //                                 else, spin waiting
        // This is similar with the "CompareAndSwap" in the lecture slide
        long startTime = System.nanoTime();
        while (flag.compareAndExchange(false, true) == true) {
            //spin-waiting in the loop until the flag is false
            //waste a lot of CPU cycles as it is checking the flag every iteration
        }
        long finishTime = System.nanoTime();
        long waitingTime = finishTime - startTime;  // calculate the time spent waiting in the while loop
        accumulatedSpinWaitTime.getAndAdd(waitingTime);
        System.out.println(Thread.currentThread().getName() + " spin-waiting for " + waitingTime + " ns");
        System.out.println(Thread.currentThread().getName() + " acquired the lock");
        flag.set(true);

    }

    public void unlock() {
        flag.set(false);
        System.out.println(Thread.currentThread().getName() + " released the lock");
    }

    public long getAccumulatedWaitingTime() {

        return accumulatedSpinWaitTime.get();
    }
}


