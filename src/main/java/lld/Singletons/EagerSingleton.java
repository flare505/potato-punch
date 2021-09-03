package lld.Singletons;

public class EagerSingleton {
    private static EagerSingleton uniqueEagerSingleton = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return uniqueEagerSingleton;
    }
}
