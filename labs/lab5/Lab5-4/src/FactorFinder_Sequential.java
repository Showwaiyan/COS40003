// Find the factors of 1000 random numbers between 5,000,000 to 8,000,000
// Sequential (Single-threaded) computation

import java.util.ArrayList;

public class FactorFinder_Sequential {
    public static void main(String[] args) {

        NumberGenerator data = new NumberGenerator(5_000_000, 8_000_000, 1000);

        System.out.println("Start counting... ");
        final long startTime = System.currentTimeMillis();

        for (Integer num : data.getNumSet()) {
            System.out.println(num + " " + findFactor(num).toString());
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (double)(endTime - startTime) / 1000 + " seconds");
    }

    // Method to find factors
    public static ArrayList<Integer> findFactor(Integer num) {

        ArrayList<Integer> factors = new ArrayList<Integer>();
        factors.add(1);             // 1 is a factor for any number
        int j = 2;
        while (j <= num / 2) {      // calculate other possible factors between 2 to num/2
            if (num % j == 0) {     // if divisible by j, then j is a factor
                factors.add(j);
            }
            j++;
        }
        factors.add(num);           // num is a factor for itself
        return factors;
    }
}
