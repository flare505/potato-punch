package lld.Singletons;

public class Main {
    public static void main(String[] args) {
        // goal of singleton:: only 1 unique object and thread safe
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton1.getClass().getName().equals(lazySingleton2.getClass().getName()));

        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton1.getClass().getName().equals(eagerSingleton2.getClass().getName()));

        DoubleCheckedSingleton doubleCheckedSingleton1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton doubleCheckedSingleton2 = DoubleCheckedSingleton.getInstance();
        System.out.println(doubleCheckedSingleton1.getClass().getName().equals(doubleCheckedSingleton2.getClass().getName()));
    }
}
