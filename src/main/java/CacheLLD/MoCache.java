package CacheLLD;

public class MoCache<Key, Value> {
    IEvictionPolicy<Key, Value> evictionPolicy;
    IStorageEngine<Key, Value> storageEngine;

    MoCache(IEvictionPolicy<Key, Value> evictionPolicy, IStorageEngine<Key, Value> storageEngine) {
        this.evictionPolicy = evictionPolicy;
        this.storageEngine = storageEngine;
    }

    void put(Key key, Value value) {
        try {
            storageEngine.add(key, value);
        } catch (StorageFullException ex) {
            System.out.println(evictionPolicy.evictKey());
            storageEngine.add(key, value);
        }
        evictionPolicy.keyAccessed(key);
    }

    Value get(Key key) {
        try{
            Value val = storageEngine.get(key);
            evictionPolicy.keyAccessed(key);
            return val;
        } catch (KeyNotFoundException ex) {
            return null;
        }
    }

    void displayAll() {

    }
}
