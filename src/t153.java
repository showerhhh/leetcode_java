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
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 分析所有可能的移动情况，最后都是以left==right结束
        return nums[left];
        //        // 另一二分查找模板，最后也都是以left==right结束循环
        //        while (left<right){
        //            mid=left+(right-left+1)/2;
        //            if(xxx){
        //                left=mid;
        //            }else {
        //                right=mid-1;
        //            }
        //        }
    }

    int findTarget(int[] nums, int target) {
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