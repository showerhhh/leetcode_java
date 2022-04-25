public class t674 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 初始化
        dp[0] = 1;
        // 计算dp数组
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int findLengthOfLCIS_v2(int[] nums) {
        int len = 1, maxLen = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }
        maxLen = Math.max(maxLen, len);
        return maxLen;
    }
}