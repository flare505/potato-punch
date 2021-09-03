package javaCore.MultiThreading.ForkJoinPoolExample;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class FactorialTask extends RecursiveTask<BigInteger> {
    public int start;
    public int end;
    int THRESHOLD = 10;


    public FactorialTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected BigInteger compute() {
        System.out.println(Thread.currentThread().getName() + " -> start:: " + this.start + " -> end:: " + this.end);
        if (this.end - this.start <= THRESHOLD) {
            return calculate();
        }
        else {
            return ForkJoinTask.invokeAll(subTask()).stream().map(ForkJoinTask::join).reduce(BigInteger.ONE, BigInteger::multiply);
        }
    }

    private BigInteger calculate() {
        return IntStream.rangeClosed(start, end).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private Collection<FactorialTask> subTask() {
        int mid = (this.start + this.end) / 2;
        List<FactorialTask> factorialTaskList = new ArrayList<>();
        factorialTaskList.add(new FactorialTask(start, mid));
        factorialTaskList.add(new FactorialTask(mid + 1, end));
        return factorialTaskList;
    }
}
