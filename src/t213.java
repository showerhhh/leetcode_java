import java.util.Arrays;

public class t213 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Solution_t213 solution = new Solution_t213();
        System.out.println(solution.rob(nums));
    }
}

class Solution_t213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] tmp1 = Arrays.copyOfRange(nums, 0, n - 1);
        int[] tmp2 = Arrays.copyOfRange(nums, 1, n);
        return Math.max(func(tmp1), func(tmp2));
    }

    int func(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}