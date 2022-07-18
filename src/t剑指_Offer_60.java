import java.util.ArrayList;

public class t剑指_Offer_60 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_60 {
    public double[] dicesProbability(int n) {
        int m = n * 6;
        int[][] dp = new int[n + 1][m + 1];  // dp[i][j]表示i个骰子，和为j的排列数。（最终结果除以6**n即可）
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                // 求dp[i][j]
                for (int t = 1; t <= 6; t++) {
                    if (j - t >= 1) {
                        dp[i][j] += dp[i - 1][j - t];
                    }
                }
            }
        }

        double all = Math.pow(6, n);
        ArrayList<Double> tmp = new ArrayList<>();
        for (int j = n; j <= m; j++) {
            tmp.add(dp[n][j] / all);
        }

        double[] result = new double[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }
        return result;
    }
}