public class t31 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        // 从后向前找到第一个不是升序的位置i。
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            swap(nums, 0, n - 1);
        } else {
            // 从i位置右侧的数字中选择比它大一点的数交换。
            int j = i + 1;
            while (j < n && nums[j] > nums[i]) {
                j++;
            }
            int tmp = nums[i];
            nums[i] = nums[j - 1];
            nums[j - 1] = tmp;
            // 逆置i右侧的数字
            swap(nums, i + 1, n - 1);
        }
    }

    void swap(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}