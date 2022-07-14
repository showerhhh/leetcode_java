package 蔚来笔试;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        t2 t = new t2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                c[i] = sc.nextInt();
            }
            System.out.println(1500 + t.f(a, b, c, k));
        }
    }

    long f(long[] a, long[] b, int[] c, int k) {
        int n = a.length;
        long[][] dp = new long[n + 1][k + 1];
        // 初始化
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
        }
        // 计算dp数组
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j - c[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + a[i - 1], dp[i - 1][j - c[i - 1]] + b[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j] + a[i - 1];
                }
            }
        }
        return dp[n][k];
    }
}
