public class t343 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[j] * dp[i - j]);
                max = Math.max(max, j * dp[i - j]);
                max = Math.max(max, dp[j] * (i - j));
                max = Math.max(max, j * (i - j));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}