public class t剑指_Offer_14_I {
    public static void main(String[] args) {
        int n = 7;
        Solution_t剑指_Offer_14_I solution = new Solution_t剑指_Offer_14_I();
        System.out.println(solution.cuttingRope(n));
    }
}

class Solution_t剑指_Offer_14_I {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }

    public int cuttingRope_2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int t = Math.max(dp[j] * (i - j), j * (i - j));
                dp[i] = Math.max(dp[i], t);
            }
        }
        return dp[n];
    }
}