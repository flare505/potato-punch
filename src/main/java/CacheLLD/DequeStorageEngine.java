package CacheLLD;

import lombok.AllArgsConstructor;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@AllArgsConstructor
class Node<Key, Value> {
    Key key;
    Value value;
}

public class DequeStorageEngine<Key, Value> implements IStorageEngine<Key, Value> {
    private int MAX_CAPACITY;
    private Map<Key, Node<Key, Value>> hashmap;
    private Deque<Node<Key, Value>> deque;

    DequeStorageEngine(int capacity) {
        this.MAX_CAPACITY = capacity;
        hashmap = new HashMap<>();
        deque = new LinkedList<>();
    }

    @Override
    public void add(Key key, Value value) {
        if (deque.size() >= MAX_CAPACITY) {
            throw new StorageFullException();
        }

    }

    @Override
    public Value remove(Key key) {
        return null;
    }

    @Override
    public Value removeLastAdded() {
        return null;
    }

    @Override
    public Value get(Key key) {
        if (hashmap.get(key) == null) {
            throw new KeyNotFoundException();
        }
        return hashmap.get(key).value;
    }

    @Override
    public void display() {
        deque.forEach(System.out::println);
    }
}
