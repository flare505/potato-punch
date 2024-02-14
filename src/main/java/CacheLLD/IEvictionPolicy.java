package CacheLLD;

public interface IEvictionPolicy<Key, Value> {
    void keyAccessed(Key key);
    Key evictKey();
}
