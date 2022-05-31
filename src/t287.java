public class t287 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t287 {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }

        int p = 0;
        while (p != slow) {
            p = nums[p];
            slow = nums[slow];
        }
        return p;
    }
}