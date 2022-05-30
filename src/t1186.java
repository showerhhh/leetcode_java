public class t1186 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1186 {
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] dp = new int[arr.length];
        int[] dp_raw = new int[arr.length];
        dp[1] = Math.max(arr[0], arr[1]);
        dp_raw[1] = Math.max(arr[0] + arr[1], arr[1]);
        int res = dp[1];
        for (int i = 2; i < arr.length; i++) {
            dp[i] = fourMax(dp[i - 1] + arr[i], dp_raw[i - 1], dp_raw[i - 1] + arr[i], arr[i]);
            dp_raw[i] = Math.max(dp_raw[i - 1] + arr[i], arr[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    int fourMax(int a, int b, int c, int d) {
        int x = Math.max(a, b);
        int y = Math.max(c, d);
        return Math.max(x, y);
    }
}