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
}