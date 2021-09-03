package algo;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths {
    public static int m, n;
    public static int[][] dp = new int[101][101];
    static boolean isSave(int i, int j) {
        return  i <= m - 1 && j <= n - 1;
    }
    static boolean isEnd(int i, int j) {
        return i == m - 1 && j == n - 1;
    }

    public static int uniquePaths(int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isEnd(i, j)) {
            return dp[i][j] = 1;
        }
        if (!isSave(i, j)) {
            return dp[i][j] = 0;
        }
        return dp[i][j] = uniquePaths(i+1, j) + uniquePaths(i, j+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(uniquePaths(0, 0));
    }
}
