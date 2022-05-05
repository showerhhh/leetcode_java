public class t55 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int far = 0;  // 保存最远可以到达的位置
        for (int i = 0; i < n; i++) {
            if (i <= far && i + nums[i] > far) {
                far = i + nums[i];
            }
            if (i > far) {
                return false;
            }
            if (far >= n - 1) {
                return true;
            }
        }
        return true;
    }

    public boolean canJump_v2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}