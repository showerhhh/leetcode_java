import java.util.HashSet;

public class t面试题_1713 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1713 {
    public int respace(String[] dictionary, String sentence) {
        HashSet<String> set = new HashSet<>();
        for (String s : dictionary) {
            set.add(s);
        }

        int n = sentence.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }
}