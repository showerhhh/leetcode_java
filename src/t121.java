public class t121 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }

    public int maxProfit_v2(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);  // 保存已遍历过的区间的最低价格
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);  // 保存已遍历过的区间所能获得最大利润
        }
        return maxProfit;
    }
}