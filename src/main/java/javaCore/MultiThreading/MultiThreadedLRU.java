package javaCore.MultiThreading;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class Add implements Runnable{
    private Map<Integer, Integer> lru;
    private int MAX_CAPACITY = 10;
    private static AtomicInteger count = new AtomicInteger(10);

    public Add(Map<Integer, Integer> map) {
       this.lru = map;
    }

    @Override
    public void run() {
        while (count.getAndDecrement() > 0) {
            Integer keyval = ThreadLocalRandom.current().nextInt(5);
            lru.put(keyval, keyval);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Get implements Runnable {
    private Map<Integer, Integer> lru;
    private int MAX_CAPACITY = 10;
    private static AtomicInteger counter = new AtomicInteger(0);

    public Get(Map<Integer, Integer> map) {
        this.lru = map;
    }

    @Override
    public void run() {
        while(true) {
            Integer keyval = ThreadLocalRandom.current().nextInt(5);
            System.out.println("Get value " + keyval + " from lru: returned- " + lru.get(keyval));
            System.out.println("lru keyset now:: " + lru.keySet().toString());
            if (counter.incrementAndGet() > 10) {
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadedLRU {
    public static void main(String[] args) {
        Map<Integer, Integer> lru = Collections.synchronizedMap(new LinkedHashMap<>(5, .75f, true));
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Add(lru));
        executorService.submit(new Get(lru));
        executorService.submit(new Get(lru));
        executorService.shutdown();
    }
}
