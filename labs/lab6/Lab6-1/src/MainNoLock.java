// In this program, we do not use any lock mechanism to protect
// the access to the shared resources - taskCount
// Thus the total count at the end is most likely wrong due to race condition
public class MainNoLock {
    public static void main(String[] args) throws InterruptedException {

        TaskCounter taskCount = new TaskCounter();
        // generate 1000 tasks to be executed by 1000 threads
        for (int i=0; i<1000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is running and completing a task");
                doSomeWork();
                taskCount.incCount();
            }).start();

        }
        // A small delay to make sure all threads are completed before
        // we proceed to print the final count
        Thread.sleep(2000);

        System.out.println("Total tasks completed = " + taskCount.getCount());
    }

    // some dummy method to simulate executing some task
    private static void doSomeWork() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
