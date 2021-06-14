package javaCore;
import java.util.*;

public class MapsNSets {
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        int[] array = new int[]{3, 4, -5, 3, 10};

        Arrays.stream(array).forEach(x -> {
            hashmap.put(x, String.valueOf(x));
            linkedHashMap.put(x, String.valueOf(x));
            treeMap.put(x, String.valueOf(x));
        });

        //Hashmap is unordered,
        // uses hashing and insertion/update takes O(1)
        // list of buckets
        // null key allowed
        System.out.println("Hashmap");
        hashmap.forEach((k, v) -> System.out.println(k + " -> " + v));

        //Linked HashMap also uses hashing, O(1)
        // insertion order is maintained
        // doubly linked list of buckets
        System.out.println("LinkedHashMap");
        linkedHashMap.forEach((k, v) -> System.out.println(k + " -> " + v));  //TODO: try to implement LRU

        //Treemap uses red-black tree datastructure,
        // ordered, O(logn)
        // null only allowed when comparable passes
        System.out.println("TreeMap");
        treeMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        //We can also pass comparator in TreeMap for ordering
        Map<Integer, String> treeMap2 = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));

        System.out.println("TreeMap with comparator");
        Arrays.stream(array).forEach(x -> treeMap2.put(x, String.valueOf(x)));
        treeMap2.forEach((k, v) -> System.out.println(k + " -> " + v));

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        // unordered
        Arrays.stream(array).forEach(hashSet::add);
        System.out.println("HashSet");
        hashSet.forEach(System.out::println);

        // ordered
        Arrays.stream(array).forEach(treeSet::add);
        System.out.println("TreeSet");
        treeSet.forEach(System.out::println);
    }
}
