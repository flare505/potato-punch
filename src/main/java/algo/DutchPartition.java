package algo;

import java.util.Arrays;

public class DutchPartition {
    public static void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 0, 2, 1, 1, 0};
        //int[] arr = new int[] {2};

        int index0 = 0;
        int index2 = arr.length - 1;

        for (int i = 0; i < index2; i++) {
            if (arr[i] == 0) {
                swap(arr, i, index0);
                index0++;
            }
            else if (arr[i] == 1) {
                // do nothing
            }
            else if (arr[i] == 2) {
                swap(arr, i, index2);
                index2--;
                // recheck i
                i--;
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
