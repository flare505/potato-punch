package schedular;

import lombok.Data;

@Data
public class Task {
    private final String id;
    private final long scheduledTime;
    private final int interval;
    private final Type taskType;
    private final Runnable task;

    public enum Type {
        NORMAL,
        FIXED_RATE,
        FIXED_DELAY
    }

    public Task(String id, long scheduledTime, int interval, Type taskType) {
        this.id = id;
        this.scheduledTime = scheduledTime;
        this.interval = interval;
        this.taskType = taskType;
        this.task = generateTask();
    }

    private Runnable generateTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Task " + id + " is running. Scheduled time: " + scheduledTime + " Current time: " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
