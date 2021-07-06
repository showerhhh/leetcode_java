public class t494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Solution_t494 solution = new Solution_t494();
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}

class Solution_t494 {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, 0, target);
        return count;
    }

    void dfs(int[] nums, int i, int curSum, int target) {
        if (i == nums.length && curSum == target) {
            count++;
            return;
        } else if (i == nums.length) {
            return;
        }

        dfs(nums, i + 1, curSum + nums[i], target);
        dfs(nums, i + 1, curSum - nums[i], target);
    }

    public int findTargetSumWays_2(int[] nums, int target) {
        // 有bug
        int M = nums.length;
        int N = target * 2;
        // dp[i][j]表示对前i个数字添加符号后和为j的表达式个数
        int[][] dp = new int[M + 1][N + 1];
        dp[0][0 + target] = 1;
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (j - nums[i - 1] >= 0 && j + nums[i - 1] <= N) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j + nums[i - 1]];
                } else if (j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        return dp[M][target + target];
    }
}