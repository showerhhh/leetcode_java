public class t392 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t392 {
    public boolean isSubsequence(String s, String t) {
        // 求s与t的最长公共子序列的长度，最后判断LCS的长度是否等于s的长度，若等于则说明s是t的子序列。
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        // 初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        // 计算dp数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m] == n;
    }

    public boolean isSubsequence_v2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == n) {
            return true;
        } else {
            return false;
        }
    }
}