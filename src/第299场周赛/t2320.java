package 第299场周赛;

public class t2320 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2320 {
    public int countHousePlacements(int n) {
        if (n == 1) {
            return 4;
        }
        if (n == 2) {
            return 9;
        }
        long[] dp = new long[n + 1];
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return (int) (dp[n] * dp[n] % 1000000007);
    }
}