public class t309 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = threeMax(dp[i - 1][0], dp[i - 1][2] - prices[i], dp[i - 1][3] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = dp[i - 1][1];
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);
        }
        return threeMax(dp[n - 1][1], dp[n - 1][2], dp[n - 1][3]);
    }

    int threeMax(int a, int b, int c) {
        int res = Math.max(a, b);
        res = Math.max(res, c);
        return res;
    }
}