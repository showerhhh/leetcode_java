public class t474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        Solution_t474 solution = new Solution_t474();
        System.out.println(solution.findMaxForm(strs, m, n));
    }
}

class Solution_t474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        // dp[i][j][k]表示在前i个字符串中选，要求0的个数小于等于j个，1的个数小于等于k个，选得的字符串最多有几个
        int[][][] dp = new int[l + 1][m + 1][n + 1];
        for (int i = 1; i <= l; i++) {
            int[] count = countZerosOnes(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j - count[0] >= 0 && k - count[1] >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[l][m][n];
    }

    int[] countZerosOnes(String str) {
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        return count;
    }
}