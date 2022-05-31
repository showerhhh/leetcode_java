public class t1277 {
}

class Solution_t1277 {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        // 计算dp数组
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = threeMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        // 统计正方形个数
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }

    int threeMin(int a, int b, int c) {
        int t = Math.min(a, b);
        return Math.min(t, c);
    }
}