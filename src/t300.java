public class t300 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 初始化
        dp[0] = 1;
        // 计算dp数组
        int res = 1;
        for (int i = 1; i < n; i++) {
            int maxi = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxi = Math.max(maxi, dp[j] + 1);
                }
            }
            dp[i] = maxi;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}