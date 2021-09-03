package javaCore.FunctionalInterface;


public class Main {
    public static void main(String[] args) {

        // consumer functional interface
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        stringConsumer.accept("Consumer:: hellow world");

        // supplier functional interface, replaced by lambda
        Supplier<String> stringSupplier = () -> "Supplier:: hellow world";
        System.out.println(stringSupplier.get());

        // Operator interfaces are special cases of a function that receive and return the same value type, unary -> function, binary -> biFunction
        // similar to bifunction, we can either create our own trifunction or use varv library
        BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer var1, Integer var2) {
                return var1 + var2;
            }
        };

        System.out.println("Bifunction::" + biFunction.apply(2, 3));
    }
}
