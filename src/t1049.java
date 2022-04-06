public class t1049 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1049 {
    public int lastStoneWeightII(int[] stones) {
        int N = stones.length;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return stones[0];
        }

        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int M = sum / 2;
        // dp[i][j]表示能否在前i个数字中选取若干数字，使得这些数字的和为j
        boolean[][] dp = new boolean[N + 1][M + 1];
        // 初始化
        for (int j = 1; j <= M; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        // 求dp数组
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 遍历dp[n]行，求两子集和的最小差值
        int res;
        if (sum % 2 == 0) {
            res = 0;
        } else {
            res = 1;
        }
        for (int j = M; j >= 0 && !dp[N][j]; j--) {
            res += 2;
        }
        return res;
    }
}