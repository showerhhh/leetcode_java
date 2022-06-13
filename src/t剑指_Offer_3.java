public class t剑指_Offer_3 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_3 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int idx = num % n;
            nums[idx] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 2 * n) {
                return i;
            }
        }
        return -1;
    }
}