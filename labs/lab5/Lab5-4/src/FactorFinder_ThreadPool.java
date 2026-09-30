import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FactorFinder_ThreadPool {
    public static void main(String[] args) {

        NumberGenerator data = new NumberGenerator(5_000_000, 8_000_000, 1000);
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService execService = Executors.newFixedThreadPool(numberOfThreads);
        System.out.println("Start counting with " + numberOfThreads + " threads...");
        final long startTime = System.currentTimeMillis();
        for (Integer num : data.getNumSet()) {
            execService.execute(() -> System.out.println(num + " " + findFactor(num).toString()));
        }

        execService.shutdown();
        try {
            execService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (double)(endTime - startTime) / 1000 + " seconds");
    }

    // Method to find factors
    public static ArrayList<Integer> findFactor(Integer num) {

        ArrayList<Integer> factors = new ArrayList<Integer>();
        factors.add(1);
        int j = 2;
        while (j <= num / 2) {
            if (num % j == 0) {
                factors.add(j);
            }
            j++;
        }
        factors.add(num);
        return factors;
    }
}
