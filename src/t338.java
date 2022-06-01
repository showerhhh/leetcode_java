public class t338 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = count(i);
        }
        return res;
    }

    int count(int n) {
        int t = 0;
        while (n != 0) {
            t += n % 2;
            n /= 2;
        }
        return t;
    }

    public int[] countBits_2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                // 奇数i的二进制中1的个数比i-1的多1个
                res[i] = res[i - 1] + 1;
            } else {
                // 偶数的二进制中1的个数和i/2的相等
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}