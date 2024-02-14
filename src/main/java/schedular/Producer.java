package schedular;

public class Producer {
    private final CustomerScheduler scheduler;

    public Producer(CustomerScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void schedule(Task task) {
        scheduler.lockQueue();
        try {
            while (scheduler.getQueue().size() >= scheduler.getSIZE()) {
                scheduler.getRemoved().await();
            }
            scheduler.getQueue().add(task);
            System.out.println("Added task: " + task);
            scheduler.getAdded().signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            scheduler.unlockQueue();
        }
    }
}
