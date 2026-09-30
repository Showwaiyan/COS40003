import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        // Create executor with 3 worker threads. Note that the executor object will automatically
        // create and start new thread when we call the execute() method.
        ExecutorService executor = Executors.newFixedThreadPool(3);
        System.out.println("Main thread started with three worker threads.");

        Median st1 = new Median(new ArrayList<Integer>(Arrays.asList(6,2,8,1,9)));
        Median st2 = new Median(new ArrayList<Integer>(Arrays.asList(5,10,20,15,30,25)));
        Median st3 = new Median(new ArrayList<Integer>(Arrays.asList(10,9,8,7,6,5,4,3,2,1)));
        Median st4 = new Median(new ArrayList<Integer>(Arrays.asList(8,9,6,3,1,0,4)));
        Median st5 = new Median(new ArrayList<Integer>(Arrays.asList(15,19,8,17,40,3,22,10)));

        // after a task/thread is completed, the return value is stored in the Future object
        // note that we use the submit() method instead of execute() method for Callable
        Future<Double> future1 = executor.submit(st1);
        Future<Double> future2 = executor.submit(st2);
        Future<Double> future3 = executor.submit(st3);
        Future<Double> future4 = executor.submit(st4);
        Future<Double> future5 = executor.submit(st5);

        System.out.println("The median value for set 1 is " + future1.get().toString());
        System.out.println("The median value for set 2 is " + future2.get().toString());
        System.out.println("The median value for set 3 is " + future3.get().toString());
        System.out.println("The median value for set 4 is " + future4.get().toString());
        System.out.println("The median value for set 5 is " + future5.get().toString());


        // not accepting new tasks, shutdown executor service after all the current tasks have completed
        executor.shutdown();
        // block main thread from termination (after call to shutdown) until all tasks have completed
        // or after 1 second timeout, whichever come first
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Main thread ended.");


    }

}
