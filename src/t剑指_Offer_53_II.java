public class t剑指_Offer_53_II {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_53_II {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (m == nums[m]) {
                l = m + 1;
            } else {
                // 只有m<nums[m]，不会有m>nums[m]
                r = m - 1;
            }
        }
        return l;
    }
}