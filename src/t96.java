public class t96 {
    public static void main(String[] args) {
        Solution_t96 solution = new Solution_t96();
        System.out.println(solution.numTrees(3));
    }
}

class Solution_t96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}