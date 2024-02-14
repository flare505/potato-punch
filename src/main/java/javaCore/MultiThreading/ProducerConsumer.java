package javaCore.MultiThreading;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Producer implements Runnable {
    private BlockingQueue blockingQueue;
    private int num = 100;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(num-- > 0) {
            try {
                blockingQueue.put(ThreadLocalRandom.current().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue blockingQueue;
    private static AtomicInteger consumed = new AtomicInteger(0);

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " Consumed event: " + blockingQueue.take());
                Thread.sleep(200);
                consumed.getAndIncrement();
                if (blockingQueue.isEmpty()) {
                    System.out.println("consumed " + consumed.get());
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<String>(5);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.submit(consumer);
        executorService.shutdown();
    }
}
