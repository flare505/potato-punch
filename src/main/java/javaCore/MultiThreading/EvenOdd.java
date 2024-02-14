package javaCore.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOdd {

    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger(0);
        ReentrantLock evenLock = new ReentrantLock();
        ReentrantLock oddLock = new ReentrantLock();

        new Thread(() -> {
            while (value.get() <= 100) {
                synchronized (value) {
                    //evenLock.lock();
                    if (value.get()%2 == 0) {
                        System.out.println(value.getAndIncrement());
                    }
                    //oddLock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            while (value.get() <= 100) {
                synchronized (value) {
                    //oddLock.lock();
                    if (value.get()%2 == 1) {
                        System.out.println(value.getAndIncrement());
                    }
                    //evenLock.unlock();
                }
            }
        }).start();
    }
}
