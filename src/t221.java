public class t221 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxArea = 0;
        // 初始化
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxArea = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxArea = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        // 计算dp数组
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = threeMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
                maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
            }
        }
        return maxArea;
    }

    int threeMin(int a, int b, int c) {
        int t = Math.min(a, b);
        return Math.min(t, c);
    }
}