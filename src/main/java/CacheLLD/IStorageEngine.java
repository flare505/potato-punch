package CacheLLD;

public interface IStorageEngine<Key, Value> {
    void add(Key key, Value value);
    Value remove(Key key);
    Value get(Key key);
    void display();
    Value removeLastAdded();
}
