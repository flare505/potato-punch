package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 */

public class KClosestElements {
    public static List<Integer> func(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        int minVal = Integer.MAX_VALUE;
        int minIndex = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(Math.abs(x - arr[mid]) < minVal) {
                minVal = Math.abs(x - arr[mid]);
                minIndex = mid;
                if (minVal == 0) {
                    break;
                }
            }
            if (x - arr[mid] > 0) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        System.out.println(minVal + "->" + minIndex + "->" + arr[minIndex]);
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[minIndex]);
        int left = minIndex - 1;
        int right = minIndex + 1;

        // assumption, k < arr.length
        for (int i = 1; i < k; i++) {
            if (left < 0) {
                ans.add(arr[right++]);
            } else if (right > arr.length - 1) {
                ans.add(arr[left--]);
            } else {
                if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
                    ans.add(arr[left--]);
                }
                else {
                    ans.add(arr[right++]);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,1,2,2,3,3,6,7,8,9,9,11,11,12,12,12,13,15,18,18,21,22,22,23,25,25,32,33,34,37,37,38,38,39,39,40,41,43,43,45,45,46,46,48,48,49,50,50,53,53,54,54,56,57,57,58,58,60,60,61,62,63,63,66,69,70,71,71,71,74,75,75,76,76,80,81,81,82,84,86,86,87,87,87,88,90,91,93,93,93,94,94,94,95,96,97,98,98,98,99};
        int k = 3;
        int x = 13;
        List<Integer> ans = func(arr, k, x);
        ans.forEach(System.out::println);
    }
}
