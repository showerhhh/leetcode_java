public class t647 {
    public static void main(String[] args) {
        Solution_t647 solution = new Solution_t647();
        String s = "abc";
        solution.countSubstrings(s);
    }
}

class Solution_t647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        // 计算dp数组
        int countFalse = 0;
        // 根据dp数组的推导，遍历顺序可以“从左到右，从上到下”，也可以“从下到上，从左到右”。
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                if (!dp[i][j]) {
                    countFalse++;
                }
            }
        }
        int res = n * (n + 1) / 2 - countFalse;
        return res;
    }

    public int countSubstrings_v2(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int start = i, end = i;
            while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int start = i, end = i + 1;
            while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            }
        }
        return count;
    }
}