public class t698 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t698 {
    boolean flag = false;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {  // 对于特殊情况，直接判断
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {  // 对于特殊情况，直接判断
            return false;
        }
        backtracking(nums, sum / k, new int[k], 0);
        return flag;
    }

    void backtracking(int[] nums, int target, int[] bucketsSum, int idx) {
        if (flag) {  // 已经得到结果，直接返回
            return;
        }
        if (idx == nums.length) {
            for (int bucketSum : bucketsSum) {
                if (bucketSum != target) {
                    return;
                }
            }
            flag = true;
            return;
        }
        for (int i = 0; i < bucketsSum.length; i++) {
            if (flag) {  // 已经得到结果，直接返回
                return;
            }
            bucketsSum[i] += nums[idx];
            backtracking(nums, target, bucketsSum, idx + 1);
            bucketsSum[i] -= nums[idx];
        }
    }
}