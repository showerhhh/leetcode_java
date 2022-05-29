public class t96 {
    public static void main(String[] args) {
        Solution_t96 solution = new Solution_t96();
        System.out.println(solution.numTrees(3));
    }
}

class Solution_t96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];  // dp[i]表示i个节点组成的二叉搜索树有多少种。
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {  // 选取第i个节点为根节点。
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}