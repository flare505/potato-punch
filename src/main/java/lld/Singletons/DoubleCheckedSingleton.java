package lld.Singletons;

public class DoubleCheckedSingleton {
    private static DoubleCheckedSingleton uniqueDoubleCheckedSingleton;

    private DoubleCheckedSingleton() {}

    public static DoubleCheckedSingleton getInstance() {
        // first check before entering synchronized, only enter once
        if (uniqueDoubleCheckedSingleton == null) {
            synchronized (DoubleCheckedSingleton.class) {
                // second check required because 1st thread might created a thread in meantime
                if (uniqueDoubleCheckedSingleton == null) {
                    uniqueDoubleCheckedSingleton = new DoubleCheckedSingleton();
                }
            }
        }
        return uniqueDoubleCheckedSingleton;
    }
}
