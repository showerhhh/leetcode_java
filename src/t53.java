public class t53 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 初始化
        dp[0] = nums[0];
        // 计算dp数组
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}