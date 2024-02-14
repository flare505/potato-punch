package schedular;

import lombok.Data;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class CustomerScheduler {
    private final int SIZE;
    private final ExecutorService executor;
    private final ReentrantLock lock;
    private final Condition added;
    private final Condition removed;
    private PriorityQueue<Task> queue;

    public CustomerScheduler(int size) {
        this.SIZE = size;
        this.executor = Executors.newFixedThreadPool(size);
        this.lock = new ReentrantLock();
        this.added = this.lock.newCondition();
        this.removed = this.lock.newCondition();
        this.queue = new PriorityQueue<Task>((a, b) -> (int) (a.getScheduledTime() - b.getScheduledTime()));
    }

    public void lockQueue() {
        this.lock.lock();
    }

    public void unlockQueue() {
        this.lock.unlock();
    }

}
