package schedular;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {

        CustomerScheduler customerScheduler = new CustomerScheduler(10);
        Task task1 = new Task("1", System.currentTimeMillis() + 10000, 1000, Task.Type.NORMAL);
        Task task2 = new Task("2", System.currentTimeMillis() + 1000, 1000, Task.Type.NORMAL);
        Task task3 = new Task("3", System.currentTimeMillis() + 100, 1000, Task.Type.NORMAL);
        Producer producer = new Producer(customerScheduler);
        producer.schedule(task1);


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Consumer consumer = new Consumer(customerScheduler);

        executorService.submit(consumer);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        producer.schedule(task2);
        producer.schedule(task3);
    }
}
