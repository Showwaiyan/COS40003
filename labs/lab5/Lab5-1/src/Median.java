import java.util.ArrayList;
import java.util.Collections;

public class Median implements Runnable {
    private ArrayList<Integer> data = new ArrayList<>();

    public Median(ArrayList<Integer> data) {

        this.data = data;
    }
    @Override
    public void run() {
        double median;
        Collections.sort(data);             // sort the data so that we can
                                            // find the median based on position
        if (data.size() % 2 == 1)
            median = data.get(data.size()/2);
        else
            median = ((double)data.get(data.size()/2) + (double) data.get(data.size()/2 - 1)) / 2;
        System.out.println(Thread.currentThread().getName() + " : Sorted data " + data + ". Median : " + median);

    }
}
