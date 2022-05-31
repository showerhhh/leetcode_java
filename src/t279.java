public class t279 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 计算dp数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}