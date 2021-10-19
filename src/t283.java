public class t283 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t283 {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}