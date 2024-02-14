package CacheLLD;

public class LRUEvictionPolicy<Key, Value> implements IEvictionPolicy<Key, Value> {
    IStorageEngine<Key, Value> storageEngine;

    LRUEvictionPolicy(IStorageEngine<Key, Value> storageEngine) {
        this.storageEngine = storageEngine;
    }

    @Override
    public void keyAccessed(Key key) {
        Value val = storageEngine.remove(key);
        storageEngine.add(key, val);
    }

    @Override
    public Key evictKey() {
        return null;
    }
}
