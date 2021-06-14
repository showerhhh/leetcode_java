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
        dp[1] = 1;
        for (int m = 2; m <= n; m++) {
            for (int i = 1; i <= m; i++) {
                dp[m] += dp[i - 1] * dp[m - i];
            }
        }
        return dp[n];
    }
}