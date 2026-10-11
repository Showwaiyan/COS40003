import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Testing {
    public static void main(String[] args) throws InterruptedException {

        SharedData data = new SharedData(0);
        EfficientLock lock = new EfficientLock();
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
    }
}
