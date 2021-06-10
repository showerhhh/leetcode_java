public class t剑指_Offer_48 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }

        int[] dp = new int[s.length()];  // 表示以下标j结尾的最长不重复子串的长度
        dp[0] = 1;
        for (int j = 1; j < dp.length; j++) {
            int i = search(s, j);
            if (i < 0) {
                dp[j] = dp[j - 1] + 1;
            } else {
                if (j - i <= dp[j - 1]) {
                    dp[j] = j - i;
                } else {
                    dp[j] = dp[j - 1] + 1;
                }
            }
        }

        // 找dp中的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    int search(String s, int j) {
        // 在下标j之前，找s[i]==s[j]，返回i，没有则返回-1
        for (int i = j - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                return i;
            }
        }
        return -1;
    }
}