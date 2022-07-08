package 第299场周赛;

public class t2321 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(f(nums1, nums2), f(nums2, nums1));
    }

    int f(int[] A, int[] B) {
        // 用B中子数组替换A的最大和
        int n = A.length;
        int sumA = 0;  // 求A的和
        for (int num : A) {
            sumA += num;
        }
        int[] C = new int[n];  // 记录B-A的差值，求最大子数组的和，即最大增益。
        for (int i = 0; i < n; i++) {
            C[i] = B[i] - A[i];
        }
        int[] dp = new int[n];
        dp[0] = C[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + C[i], C[i]);
            max = Math.max(max, dp[i]);
        }
        return sumA + max;
    }
}