// In this example we use Callable instead of Runnable
// Callable interface allows the thread to return a value to the main thread

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class Median implements Callable<Double> {
    private ArrayList<Integer> data = new ArrayList<>();

    public Median(ArrayList<Integer> data) {

        this.data = data;
    }
    @Override
    public Double call() {
        double median;
        Collections.sort(data);
        if (data.size() % 2 == 1)
            median = data.get(data.size()/2);
        else
            median = ((double)data.get(data.size()/2) + (double) data.get(data.size()/2 - 1)) / 2;
        return median;
    }
}
