public class t115 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t115 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        // 初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }
        // 计算dp数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 当s[i-1]与t[j-1]能匹配时，可以考虑用s[i-2]与t[j-1]匹配的个数（dp[i-1][j]），和s[i-1]与t[j-1]匹配的个数（dp[i-1][j-1]）
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 当s[i-1]与t[j-1]不能匹配时，只能考虑用s[i-2]与t[j-1]匹配的个数（dp[i-1][j]）
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}