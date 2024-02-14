package algo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InterleavingStrings {

    public static boolean func(String s1, int i, String s2, int j, String s3, int k, int[][] dp) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (k == s3.length()) {
            return false;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = ans || func(s1, i+1, s2, j, s3, k+1, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = ans || func(s1, i, s2, j+1, s3, k+1, dp);
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        IntStream.range(0, s1.length() + 1).forEach(i -> Arrays.fill(dp[i], -1));
        return func(s1, 0, s2, 0, s3, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
