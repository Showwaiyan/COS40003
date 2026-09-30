import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// We implement our own custom ThreadFactory here

public class MyThreadFactory implements ThreadFactory {
    private final String namePrefix;    // Prefix of thread's name
    // AtomicInteger is used to make sure only one thread can increment the threadNumber at a time
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public MyThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        // Create thread with specific name
        Thread t = new Thread(r, namePrefix + "#" + threadNumber.getAndIncrement());
        t.setPriority(Thread.NORM_PRIORITY);
        t.setUncaughtExceptionHandler((thread, e) -> System.err.println("Uncaught exception in " + thread.getName() + ": " + e.getMessage()));
        return t;
    }
}
