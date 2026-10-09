// This example demonstrates the use of AtomicInteger class
// AtomicInteger ensure that its value is accessed atomically

public class MainClass {
    public static void main(String[] args) {

        // Jobs job1 = new Jobs();
        AtomicJobs job1 = new AtomicJobs();

        // run 2 threads "procesing" 10000 and 5000 jobs respectively
        Thread t1 = new Thread (()->job1.completeJob(10000));
        Thread t2 = new Thread (()->job1.completeJob(5000));
        // The above is lambda expression. It is the same with the code below
        /*
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                job1.completeJob(10000);
            }
        });
        */
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Total number of jobs completed by both thread = " + job1.getNumberOfJobsDone());
    }

}
