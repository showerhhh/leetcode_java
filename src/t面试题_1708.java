import java.util.Arrays;
import java.util.Comparator;

public class t面试题_1708 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1708 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        int[][] person = new int[n][2];
        for (int i = 0; i < n; i++) {
            person[i][0] = height[i];
            person[i][1] = weight[i];
        }
        Arrays.sort(person, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    if (o1[1] > o2[1]) {
                        return -1;
                    } else if (o1[1] < o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = person[i][1];
        }
        return LIS_1(w, n);
    }

    int LIS_1(int[] w, int n) {
        // 动态规划法
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int tmp = 1;
            for (int j = 0; j < i; j++) {
                if (w[j] < w[i]) {
                    tmp = Math.max(tmp, dp[j] + 1);
                }
            }
            dp[i] = tmp;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}