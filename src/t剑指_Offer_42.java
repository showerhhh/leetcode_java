public class t剑指_Offer_42 {
    public static void main(String[] args) {
        Solution_t剑指_Offer_42 solution = new Solution_t剑指_Offer_42();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}

class Solution_t剑指_Offer_42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j : dp) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}