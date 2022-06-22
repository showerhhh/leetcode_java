public class t153 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        Solution_t153 solution = new Solution_t153();
        solution.findMin(nums);
    }
}

class Solution_t153 {
    public int findMin(int[] nums) {
        // 最小值在[left, right]中查找，循环结束时left==right，即查找到最小值。
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}