import java.util.concurrent.atomic.AtomicInteger;

public class FairLock {
    private AtomicInteger ticket = new AtomicInteger();
    private AtomicInteger turn = new AtomicInteger();
    public FairLock() {
        ticket.set(0);
        turn.set(0);
    }

    public void lock() {
        int myTurn = ticket.getAndIncrement();  // get a ticket (queue order)

        // if turn equals to myTurn (ticket number), then proceed
        // otherwise, wait
        while (turn.get() != myTurn) {      // no more spin-waiting
            Thread.yield();                 // voluntary give up CPU times. Hence, would not waste CPU cycles
        }

       System.out.println(Thread.currentThread().getName() + " acquired the lock");

    }

    public void unlock() {
        turn.getAndIncrement();     // When my turn end, increase the turn value for the next thread to proceed
        System.out.println(Thread.currentThread().getName() + " released the lock");
    }

}
