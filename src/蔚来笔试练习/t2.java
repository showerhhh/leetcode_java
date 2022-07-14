package 蔚来笔试练习;

public class t2 {
    public static void main(String[] args) {
        t2 t = new t2();
        int res = t.f(2, 3, 5, 20);
        System.out.println(res);
    }

    int f(int x, int y, int a, int b) {
        if (b % a != 0) {
            return -1;
        }
        int M = b / a;
        int[][] dp = new int[3][M + 1];
        dp[0][1] = 0;
        for (int j = 2; j <= M; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= M; j++) {
            if (j % x == 0 && dp[1][j / x] != Integer.MAX_VALUE) {
                dp[1][j] = Math.min(dp[0][j], dp[1][j / x] + 1);
            } else {
                dp[1][j] = dp[0][j];
            }
        }
        for (int j = 1; j <= M; j++) {
            if (j % y == 0 && dp[2][j / y] != Integer.MAX_VALUE) {
                dp[2][j] = Math.min(dp[1][j], dp[2][j / y] + 1);
            } else {
                dp[2][j] = dp[1][j];
            }
        }
        return dp[2][M];
    }
}
