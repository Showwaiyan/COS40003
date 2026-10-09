// Using AtomicInteger for count
// count can only be modified by one thread at a time

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicJobs {
    private AtomicInteger count = new AtomicInteger();
    public AtomicJobs() {
        // initial value of count is set to 0
        count.set(0);
    }

    public void completeJob(int numJobs) {
        for (int i = 0; i < numJobs; i++) {
            count.getAndIncrement();    // read and increase count atomically
        }
        System.out.println("Completed " + numJobs + " jobs.");
    }

    public int getNumberOfJobsDone() {
        return count.get();         // get the current value of count
    }
}
