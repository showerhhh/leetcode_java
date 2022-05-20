public class t5 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        // 计算dp数组
        int maxLength = 0, maxi = 0, maxj = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    maxi = i;
                    maxj = j;
                }
            }
        }
        // 求最长的回文子串
        return s.substring(maxi, maxj + 1);
    }

    public String longestPalindrome_v2(String s) {
        int n = s.length();
        int maxLength = 0, maxi = 0, maxj = 0;
        for (int i = 0; i < n; i++) {
            int[] span = expand(s, i, i);
            if (span[1] - span[0] + 1 > maxLength) {
                maxLength = span[1] - span[0] + 1;
                maxi = span[0];
                maxj = span[1];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int[] span = expand(s, i, i + 1);
            if (span[1] - span[0] + 1 > maxLength) {
                maxLength = span[1] - span[0] + 1;
                maxi = span[0];
                maxj = span[1];
            }
        }
        return s.substring(maxi, maxj + 1);
    }

    int[] expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}