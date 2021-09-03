package javaCore.FunctionalInterface;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}