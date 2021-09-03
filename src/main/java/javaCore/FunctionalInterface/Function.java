package javaCore.FunctionalInterface;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
