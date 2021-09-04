public class t153 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        Solution_t153 solution = new Solution_t153();
        solution.findMin(nums);
    }
}

class Solution_t153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            if(nums[left]<nums[right]){
                // left到right范围内递增
                return nums[left];
            }
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else {
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}