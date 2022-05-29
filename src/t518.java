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
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }

    public int change_v2(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        // 初始化
        dp[0][0] = 1;
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        // 计算dp数组
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][amount];
    }
}