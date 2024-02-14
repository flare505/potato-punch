package schedular;

public class Consumer implements Runnable {
    private final CustomerScheduler scheduler;

    public Consumer(CustomerScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void consume() {
        scheduler.lockQueue();
        try {
            while (true) {
                if (scheduler.getQueue().isEmpty()) {
                    scheduler.getAdded().await();
                }
                Task task  = scheduler.getQueue().peek();
                while (task.getScheduledTime() > System.currentTimeMillis()) {
                    task  = scheduler.getQueue().peek();
                }

                task = scheduler.getQueue().poll();
                System.out.println("Consumed task: " + task);
                executeTask(task);
                scheduler.getRemoved().signal();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            scheduler.unlockQueue();
        }
    }

    private void executeTask(Task task) {
        scheduler.getExecutor().submit(task.getTask());
    }

    @Override
    public void run() {
        consume();
    }
}
