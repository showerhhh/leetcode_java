public class t581 {
    public static void main(String[] args) {
        Solution_t581 solution = new Solution_t581();
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        solution.findUnsortedSubarray(nums);
    }
}

class Solution_t581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], right = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < leftMax) {
                right = i;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        int rightMin = nums[n - 1], left = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > rightMin) {
                left = i;
            }
            rightMin = Math.min(rightMin, nums[i]);
        }
        if (left >= right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }
}