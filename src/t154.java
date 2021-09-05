public class t154 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        // 分析所有可能的移动情况，最后都是以left==right结束
        return nums[left];
    }
}