public class t63 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 1; j < n; j++) {
            if (dp[0][j - 1] == 1 && obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        // 求解
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}