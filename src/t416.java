public class t416 {
    public static void main(String[] args) {
        Solution_t416 solution = new Solution_t416();
        int[] nums = {3, 3, 3, 4, 5};
        System.out.println(solution.canPartition(nums));
    }
}

class Solution_t416 {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        if (N < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        // dp[i][j]表示能否在前i个数字中选取若干数字，使得这些数字的和为j
        boolean[][] dp = new boolean[N + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][target];
    }
}