package lld.Singletons;

public class LazySingleton {

    private static LazySingleton uniqueLazySingleton;

    // constructor must be private
    private LazySingleton() {}

    // synchronized getInstance is costly, should avoid synchronized somehow
    public static synchronized LazySingleton getInstance() {
        // lazy loading
        if (uniqueLazySingleton == null) {
            uniqueLazySingleton = new LazySingleton();
        }
        return uniqueLazySingleton;
    }
}
