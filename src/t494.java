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
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        // 特殊情况直接返回
        if (target + sum < 0) {
            return 0;
        }
        if ((target + sum) % 2 == 1) {
            return 0;
        }
        int M = (target + sum) / 2;
        // dp[i][j]表示从前i个数中选出若干数字，和为j，有几种方法。
        int[][] dp = new int[N + 1][M + 1];
        // 初始化
        dp[0][0] = 1;
        for (int j = 1; j <= M; j++) {
            dp[0][j] = 0;
        }
        // dp数组计算
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[N][M];
    }
}