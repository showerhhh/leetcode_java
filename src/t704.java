public class t704 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t704 {
    public int search(int[] nums, int target) {
        // 二分查找模板
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}