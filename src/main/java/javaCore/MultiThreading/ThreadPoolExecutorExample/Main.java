package javaCore.MultiThreading.ThreadPoolExecutorExample;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //ExecutorService interface has no api for queue or pool size

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "hello " + Thread.currentThread().getName();
            }
        });

        Future<String> future2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "hello " + Thread.currentThread().getName();
            }
        });

        Future<String> future3 = executorService.submit(() -> {
            Thread.sleep(1000);
            return "hello " + Thread.currentThread().getName();
        });

        try {
            System.out.println(executorService.getPoolSize()); // 2 active at the thread pool
            System.out.println(executorService.getQueue().size()); // 1 waiting in the queue
            System.out.println(future.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (Exception e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
