package 杭州未来科技城数字经济人才编程大赛2022;

public class t2 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2 {
    public int minSwaps(int[] chess) {
        int n = chess.length;
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (chess[i] == 1) {
                m++;
            }
        }
        int count0 = 0, count1 = 0;
        for (int i = 0; i < m; i++) {
            if (chess[i] == 0) {
                count0++;
            } else {
                count1++;
            }
        }
        int res = count0;
        int l = 0, r = m;
        while (r < n) {
            if (chess[r] == 0) {
                count0++;
            } else {
                count1++;
            }
            r++;
            if (chess[l] == 0) {
                count0--;
            } else {
                count1--;
            }
            l++;
            res = Math.min(res, count0);
        }
        return res;
    }
}