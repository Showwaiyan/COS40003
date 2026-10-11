import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class EfficientLock {
    private AtomicInteger ticket = new AtomicInteger();
    private AtomicInteger turn = new AtomicInteger();
    private LinkedBlockingQueue<HashMap<Integer, Thread>> queue;    //Queue for the waiting threads
    private HashMap<Integer, Thread> curThread;                     //The current thread that try to acquire the lock but fail
    public EfficientLock() {
        ticket.set(0);
        turn.set(0);
        queue = new LinkedBlockingQueue<>();
        curThread = new HashMap<>();
    }

    public void lock() {
        int myTurn = ticket.getAndIncrement();  // get a ticket (queue order)

        // if turn equals to myTurn (ticket number), then proceed
        // otherwise, wait
        while (turn.get() != myTurn) {
            curThread.put(myTurn, Thread.currentThread());
            this.queue.add(curThread);  // add the current thread to the queue
            LockSupport.park();         // put the current thread to waiting state.
        }

        System.out.println(Thread.currentThread().getName() + " acquired the lock");

    }

    public void unlock() {
        turn.getAndIncrement();     // When my turn end, increase the turn value for the next thread to proceed
        Thread nextThread = curThread.remove(turn.get());   // pick the next thread to run based on the "turn" value
        LockSupport.unpark(nextThread);                     // put that thread back to the ready state so that it can be scheduled to run
        System.out.println(Thread.currentThread().getName() + " released the lock");
    }

}

