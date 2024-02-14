package javaCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.addAll(Arrays.asList(4, 5, 6));

        list2.forEach(System.out::println);
    }

}
