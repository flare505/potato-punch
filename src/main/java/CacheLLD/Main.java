package CacheLLD;

public class Main {
    public static void main(String[] args) {
        IStorageEngine<String, String> storageEngine = new DequeStorageEngine<>(3);
        IEvictionPolicy<String, String> evictionPolicy = new LRUEvictionPolicy<>(storageEngine);
        MoCache<String, String> myCache = new MoCache<>(evictionPolicy, storageEngine);

        myCache.put("2", "two");
        myCache.put("3", "three");
        System.out.println(myCache.get("2"));
        myCache.put("4", "four");
        myCache.put("5", "five");
        System.out.println(myCache.get("2"));
        myCache.displayAll();
    }
}
