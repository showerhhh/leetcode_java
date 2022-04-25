public class t188 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2 * k + 1];
        // 初始化
        for (int j = 0; j < 2 * k + 1; j++) {
            if (j % 2 == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = -prices[0];
            }
        }
        // 计算dp数组
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * k + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[n - 1][2 * k];
    }
}