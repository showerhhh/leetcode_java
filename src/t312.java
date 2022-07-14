public class t312 {
    public static void main(String[] args) {
        Solution_t312 solution = new Solution_t312();
        int[] nums = new int[]{3, 1, 5, 8};
        solution.maxCoins(nums);
    }
}

class Solution_t312 {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] qiqiu = new int[n];
        qiqiu[0] = 1;
        qiqiu[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            qiqiu[i + 1] = nums[i];
        }
        int[][] dp = new int[n][n];
        // 初始化
        for (int i = 0; i <= n - 2; i++) {
            int j = i + 1;
            dp[i][j] = 0;
        }
        // 计算dp数组
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int tmp = 0;
                for (int k = i + 1; k < j; k++) {
                    tmp = Math.max(tmp, dp[i][k] + qiqiu[i] * qiqiu[k] * qiqiu[j] + dp[k][j]);
                }
                dp[i][j] = tmp;
            }
        }
        return dp[0][n - 1];
    }
}