import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String args[]) throws InterruptedException {

        // Create ThreadPoolExecutor with 2 worker threads initially, potentially increase to 3 worker threads.
        // Remove extra thread if idle for 60 seconds
        // The worker threads are created based on MyThreadFactory class.
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                3,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),
                new MyThreadFactory("Worker_Thread")
        );
        System.out.println("Main thread started.");


        Median st1 = new Median(new ArrayList<Integer>(Arrays.asList(6,2,8,1,9)));
        Median st2 = new Median(new ArrayList<Integer>(Arrays.asList(5,10,20,15,30,25)));
        Median st3 = new Median(new ArrayList<Integer>(Arrays.asList(10,9,8,7,6,5,4,3,2,1)));
        Median st4 = new Median(new ArrayList<Integer>(Arrays.asList(8,9,6,3,1,0,4)));
        Median st5 = new Median(new ArrayList<Integer>(Arrays.asList(15,19,8,17,40,3,22,10)));

        // Note that after completing a task, a worker thread will return to the thread pool and
        // ready to accept a new task.
        executor.execute(st1);
        executor.execute(st2);
        executor.execute(st3);
        executor.execute(st4);
        executor.execute(st5);


        // not accepting new tasks, shutdown executor service after all the current tasks have completed
        executor.shutdown();
        // block main thread from termination (after call to shutdown) until all tasks have completed
        // or after 1 second timeout, whichever come first
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Main thread ended.");


    }

}
