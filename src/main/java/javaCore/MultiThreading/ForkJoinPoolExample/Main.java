package javaCore.MultiThreading.ForkJoinPoolExample;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        FactorialTask factorialTask = new FactorialTask(1, 100);
        System.out.println(forkJoinPool.invoke(factorialTask));
    }
}
