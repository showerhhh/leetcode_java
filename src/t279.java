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
        for (int j = 1; j <= n; j++) {
            int tmp = Integer.MAX_VALUE;
            for (int i = 1; i * i <= j; i++) {
                tmp = Math.min(tmp, dp[j - i * i] + 1);
            }
            dp[j] = tmp;
        }
        return dp[n];
    }
}