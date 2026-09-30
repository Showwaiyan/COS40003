import java.util.ArrayList;

public class FactorFinder_VirtualThread {
    public static void main(String[] args) {

        NumberGenerator data = new NumberGenerator(5_000_000, 8_000_000, 1000);
        Thread[] threads = new Thread[1000];
        System.out.println("Start counting... ");
        final long startTime = System.currentTimeMillis();

        int i = 0;
        for (Integer num : data.getNumSet()) {
            threads[i] = Thread.startVirtualThread (()-> System.out.println(num + " " + findFactor(num).toString()));
            i++;
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

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
