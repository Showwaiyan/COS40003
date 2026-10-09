/*
This example demonstrate the disadvantage of spin-waiting lock.
Threads that are waiting for the lock to be available spend a lot of time "spinning"
(keep checking for the availability of the lock in a loop), which waste CPU time.
------------------------------------------------------------------------------
Beside that, the SimpleLock implementation in this example also is not fair.
You can see from the output that certain thread may have to wait for longer period.
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Testing {
    public static void main(String[] args) throws InterruptedException {

        SharedData data = new SharedData(0);
        SimpleLock lock = new SimpleLock();
        final int numberOfThreads = 16;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executor.execute(new Thread(()-> {
                // Each thread increment the shared data many times
                for (int j = 0; j < 1000; j++) {
                    lock.lock();                    // acquire the lock before access to shared data
                    data.increment();
                    lock.unlock();                 // release the lock after finish
                }

            }));
        }

        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.MINUTES);

        System.out.println("Final value of data is " + data.getData());
        System.out.println("Average time spent by each thread in spin-waiting is " + (lock.getAccumulatedWaitingTime()/numberOfThreads)/1000000 + " ms");
    }
}
