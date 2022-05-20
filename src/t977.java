public class t977 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t977 {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        int[] nums2 = new int[nums.length];
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                nums2[k] = nums[i] * nums[i];
                k--;
                i++;
            } else {
                nums2[k] = nums[j] * nums[j];
                k--;
                j--;
            }
        }
        return nums2;
    }
}