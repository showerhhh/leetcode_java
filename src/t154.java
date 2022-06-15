public class t154 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t154 {
    public int findMin(int[] nums) {
        // 最小值在[left, right]中查找，循环结束时left==right，即查找到最小值。
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // nums[mid]==nums[right]时，不能确定最小值在mid左侧还是右侧，因此要变为顺序查找
                // 因为nums[mid]==nums[right]，所以移动right。（不知道nums[mid]是否等于nums[left]，所以不能移动left）
                right--;
            }
        }
        // 所有移动情况最后都是以left==right结束
        return nums[left];
    }
}