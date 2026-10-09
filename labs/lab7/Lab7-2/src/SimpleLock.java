// Very simple lock implementation - only provide acquire (lock) and release (unlock) methods

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleLock {
    private AtomicBoolean flag = new AtomicBoolean();
    public SimpleLock() {
        // set the flag to false initially
        flag.set(false);
        // false = lock available, true = lock is taken
    }

    public void acquire() {
        // Get the current flag value: if it is false, set it to true
        //                             else, spin waiting
        // This is similar with the "TestAndSet" in the lecture slide
        while (flag.getAndSet(true) == true);

    }

    public void release() {

        flag.set(false);
    }
}
