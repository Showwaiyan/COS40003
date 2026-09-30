import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberGenerator {

    private final Set<Integer> numSet;
    public NumberGenerator(int min, int max, int size) {
        Random rand = new Random();
        numSet = rand.ints(size, min, max).distinct().boxed().collect(Collectors.toSet());

    }
    public Set<Integer> getNumSet() {

        return numSet;
    }
}
