package algo;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayConsSubsequence {
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.merge(nums[i], 1, Integer::sum);
        }
        int k = 0;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[] {1, 2, 3, 3, 4, 5}));
    }
}
