import java.util.ArrayList;
import java.util.List;

public class t377 {
    public static void main(String[] args) {
        Solution_t377 solution = new Solution_t377();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        solution.combinationSum4_v2(nums, target);
    }
}

class Solution_t377 {
    ArrayList<List<Integer>> res;

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 初始化
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            dp[j] = 0;
        }
        // 计算dp数组
        for (int j = 0; j <= target; j++) {
            for (int i = 1; i <= nums.length; i++) {
                if (j - nums[i - 1] >= 0) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }

    public int combinationSum4_v2(int[] nums, int target) {
        res = new ArrayList<>();
        backtracking(nums, target, new ArrayList<>(), 0);
        return res.size();
    }

    void backtracking(int[] nums, int target, ArrayList<Integer> list, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, target, list, sum + nums[i]);
            list.remove(list.size() - 1);
        }
    }
}