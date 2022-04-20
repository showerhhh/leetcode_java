public class t279 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t279 {
    public int numSquares(int n) {
        int m = n;
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        // 计算dp数组
        for (int i = 1; i * i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - i * i >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}