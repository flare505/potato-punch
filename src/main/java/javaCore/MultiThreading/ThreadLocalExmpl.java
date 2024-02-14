package javaCore.MultiThreading;

public class ThreadLocalExmpl {
    public static void main(String[] args) {
        ThreadLocal<Integer> vals = ThreadLocal.withInitial(() -> 0);

        new Thread(() -> {
            while (vals.get() < 100) {
                vals.set(vals.get() + 1);
                if (vals.get() == 100) {
                    System.out.println(Thread.currentThread().getName() + " -> " + vals.get());
                }
            }
        }).start();

        new Thread(() -> {
            while (vals.get() < 100) {
                vals.set(vals.get() + 1);
                if (vals.get() == 100) {
                    System.out.println(Thread.currentThread().getName() + " -> " + vals.get());
                }
            }
        }).start();

        new Thread(() -> {
            while (vals.get() < 100) {
                vals.set(vals.get() + 1);
                if (vals.get() == 100) {
                    System.out.println(Thread.currentThread().getName() + " -> " + vals.get());
                }
            }
        }).start();
    }
}
