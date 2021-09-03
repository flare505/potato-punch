package algo;

import java.util.Arrays;


public class JumpGame7 {

    public static boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') return false;

        int[] arr = s.chars().map(i -> i - '0').toArray();
        int[] dp = new int[arr.length + 1];

        Arrays.fill(dp, 0);
        dp[0] = 1;

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) continue;
            if (i - minJump >= 0) {
                dp[i] = dp[i] | dp[i - minJump];
            }
            if (i - maxJump >= 0) {
                dp[i] = dp[i] | dp[i - maxJump];
            }
        }
        return dp[arr.length - 1] == 1;
    }

    public static void main(String[] args) {
        System.out.println(canReach("0110110", 2, 3));
    }
}
