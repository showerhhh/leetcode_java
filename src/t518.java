public class t518 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 1;
        for (int j = 1; j <= amount; j++) {
            dp[j] = 0;
        }
        // dp数组计算
        for (int i = 1; i <= coins.length; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}