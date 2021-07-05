import java.util.HashSet;
import java.util.List;

public class t139 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        // dp[i]表示s[0, i-1]是否可以成功拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}