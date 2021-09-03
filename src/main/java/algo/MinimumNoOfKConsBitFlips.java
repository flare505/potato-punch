package algo;

import java.util.Arrays;

public class MinimumNoOfKConsBitFlips {

    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flips = new int[n+1];
        Arrays.fill(flips, 0);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                flips[i] += flips[i-1];
            }

            if (nums[i] == 0 && flips[i] % 2 == 0) {
                flips[i] += 1;
                if (i + k > n) {
                    return -1;
                }
                flips[i + k] -= 1;
                ans++;
            } else if (nums[i] == 1 && flips[i] % 2 == 1) {
                flips[i] += 1;
                if (i + k > n) {
                    return -1;
                }
                flips[i + k] -= 1;
                ans++;
            }
        }
        //Arrays.stream(flips).forEach(System.out::println);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3));
    }
}
