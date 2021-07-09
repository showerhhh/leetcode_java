package 其他;

public class t1 {
    // 01背包问题
    /*
     * dp问题注意：
     * 1、dp的含义定义
     * 2、边界初始化
     * 3、下标i，j的变化
     * */
    public int f1(int[] w, int[] v, int W) {
        int N = w.length;
        int[][] dp = new int[N + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j - w[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public int f2(int[] w, int[] v, int W) {
        // 使用一位数组存储dp，需要注意：
        // 1、i从0开始也比较方便了
        // 2、当j<w[i]时，dp[j]=dp[j]，此时不做操作，因此可以改变遍历的范围
        // 3、j必须逆序遍历
        int N = w.length;
        int[] dp = new int[W + 1];
        for (int j = 0; j <= W; j++) {
            dp[j] = 0;
        }
        for (int i = 0; i < N; i++) {
            for (int j = W; j - w[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[W];
    }
}
