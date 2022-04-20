public class t322 {
    public static void main(String[] args) {
        Solution_t322 solution = new Solution_t322();
        int[] coins = new int[]{2};
        int amount = 3;
        solution.coinChange(coins, amount);
    }
}

class Solution_t322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        // 计算dp数组
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0 && dp[j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        } else {
            return -1;
        }
    }
}