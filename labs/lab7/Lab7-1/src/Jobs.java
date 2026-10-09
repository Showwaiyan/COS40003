// Without using AtomicInteger for count, the value of count will not
// be correct when we run multiple threads due to race condition

public class Jobs {
    private int count;
    public Jobs() {
        count = 0;
    }

    // a dummy method to simulate job processing
    public void completeJob(int numJobs) {
        for (int i = 0; i < numJobs; i++) {
            count++;
        }
        System.out.println("Completed " + numJobs + " jobs.");
    }

    public int getNumberOfJobsDone() {

        return count;
    }
}
