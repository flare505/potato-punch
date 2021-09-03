package algo;

// memory limit exceeded
public class MaxStockProfitKTransactions {
    static int[] pricesGlobal = new int[1011];
    static int[][][] dp = new int[101][1011][1011];
    public static int func(int k, int currIndex, int buyIndex) {
        if (dp[k][currIndex][buyIndex] != -1) {
            return dp[k][currIndex][buyIndex];
        }
        if (k == 0 || currIndex == pricesGlobal.length) {
            return dp[k][currIndex][buyIndex] = 0;
        }
        if (buyIndex == 1010) {
            return dp[k][currIndex][buyIndex] = Integer.max(func(k, currIndex + 1, currIndex), func(k, currIndex + 1, 1010));
        }
        else {
            return dp[k][currIndex][buyIndex] = Integer.max((pricesGlobal[currIndex] - pricesGlobal[buyIndex]) + func(k-1, currIndex + 1, 1010), func(k, currIndex + 1, buyIndex));
        }
    }
    public static int maxProfit(int k, int[] prices) {
        pricesGlobal = prices;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 1011; j++) {
                for (int l = 0; l < 1011; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return func(k, 0, 1010);
    }
    public static void main(String[] args) {
        int k = 2;
        int[] prices = new int[] {2, 4, 1};
        System.out.println(maxProfit(k, prices));
    }
}
