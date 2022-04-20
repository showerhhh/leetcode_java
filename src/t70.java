public class t70 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t70 {
    public static final int m = 2;

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            dp[j] = 0;
        }
        // 计算dp数组
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j - i >= 0) {
                    dp[j] = dp[j] + dp[j - i];
                }
            }
        }
        return dp[n];
    }
}