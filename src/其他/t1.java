package 其他;

public class t1 {
    // 01背包问题
    public int f_v1(int[] w, int[] v, int W) {
        int N = w.length;
        // dp[i][j]表示从前i个物品（[0~i-1]）中选择，放入容量为j的背包中，最大价值。
        int[][] dp = new int[N + 1][W + 1];
        // 初始化
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        // 计算dp数组
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

    public int f_v2(int[] w, int[] v, int W) {
        // 使用一位数组存储dp，需要注意：内层循环从后向前遍历，这样可以确保物品最多只能被添加一次。
        int N = w.length;
        int[] dp = new int[W + 1];
        // 初始化
        for (int j = 0; j <= W; j++) {
            dp[j] = 0;
        }
        // 计算dp数组
        for (int i = 1; i <= N; i++) {
            for (int j = W; j >= 0; j--) {
                if (j - w[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[W];
    }
}

class t1_v2 {
    static final int INIT_NUM = -1;
    int[] w;
    int[] v;
    int[][] dp;

    public static void main(String[] args) {
        t1_v2 object = new t1_v2();
        int[] w = new int[]{1, 3, 4};
        int[] v = new int[]{15, 20, 30};
        int W = 4;
        System.out.println(object.f(w, v, W));
    }

    public int f(int[] w, int[] v, int W) {
        this.w = w;
        this.v = v;
        int N = w.length;
        dp = new int[N][W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = INIT_NUM;
            }
        }
        return dp_f(N - 1, W);
    }

    int dp_f(int i, int j) {
        if (dp[i][j] != INIT_NUM) {  // 不是初始化值，说明已经dp[i][j]已经被计算和保存过，直接用。
            return dp[i][j];
        }

        // 初始化
        if (i == 0) {
            if (j < w[0]) {
                dp[i][j] = 0;
            } else {
                dp[i][j] = v[0];
            }
            return dp[i][j];
        }
        if (j == 0) {
            dp[i][j] = 0;
            return dp[i][j];
        }

        // 递归调用
        if (j - w[i] >= 0) {
            dp[i][j] = Math.max(dp_f(i - 1, j), dp_f(i - 1, j - w[i]) + v[i]);
        } else {
            dp[i][j] = dp_f(i - 1, j);
        }
        return dp[i][j];
    }
}