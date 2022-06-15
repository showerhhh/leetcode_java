public class t10 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t10 {
    public boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = false;
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (p.charAt(j - 1) >= 'a' && p.charAt(j - 1) <= 'z' || p.charAt(j - 1) == '.') {
                    // p[j-1]是字符或.
                    if (i - 1 >= 0 && match(s, p, i - 1, j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    // p[j-1]是*
                    if (j - 2 >= 0) {
                        dp[i][j] = dp[i][j] || dp[i][j - 2];  // 不使用 字符*
                    }
                    if (i - 1 >= 0 && match(s, p, i - 1, j - 2)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];  // 使用 字符*
                    }
                }
            }
        }
        return dp[N][M];
    }

    boolean match(String s, String p, int i, int j) {
        // 判断s[i]与p[j]是否匹配
        if (p.charAt(j) == '.') {
            return true;
        } else {
            return s.charAt(i) == p.charAt(j);
        }
    }
}