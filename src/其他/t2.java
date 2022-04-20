package 其他;

public class t2 {
    // 完全背包问题
    public int f1(int[] w, int[] v, int W) {
        int N = w.length;
        int[][] dp = new int[N + 1][W + 1];
        // 初始化
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        // 计算dp数组
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k * w[i - 1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * w[i - 1]] + k * v[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    public int f2(int[] w, int[] v, int W) {
        int N = w.length;
        int[] dp = new int[W + 1];
        // 初始化
        for (int j = 0; j <= W; j++) {
            dp[j] = 0;
        }
        // 计算dp数组
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j - w[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[W];
    }
}
