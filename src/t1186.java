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
        int n = arr.length;
        int[] dp_1 = new int[n];
        int[] dp_2 = new int[n];
        dp_1[1] = Math.max(arr[1], arr[0] + arr[1]);
        dp_2[1] = Math.max(arr[0], arr[1]);
        int res = Math.max(dp_1[1], dp_2[1]);
        for (int i = 2; i < n; i++) {
            dp_1[i] = Math.max(arr[i], dp_1[i - 1] + arr[i]);
            dp_2[i] = Math.max(dp_1[i - 1], dp_2[i - 1] + arr[i]);
            res = threeMax(res, dp_1[i], dp_2[i]);
        }
        return res;
    }

    int threeMax(int a, int b, int c) {
        int d = Math.max(a, b);
        return Math.max(c, d);
    }
}