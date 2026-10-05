//The instance of this class is used to keep track the number of tasks completed
public class TaskCounter {
    private int count;
    public TaskCounter() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    // This method is synchronized, which means only 1 thread can execute it at a time (for the same instance)
    public synchronized void incCount() {
        /* or using the synchronized block like below
        synchronized (this) {
            this.count++;
        }
        */

        this.count++;
    }
}
