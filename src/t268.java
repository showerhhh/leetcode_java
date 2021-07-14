public class t268 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t268 {
    public int missingNumber(int[] nums) {
        int max = -1;
        int sum = 0;
        boolean flag = false;  // 标记数组中是否有0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] == 0) {
                flag = true;
            }
        }
        int sum_t = (max + 1) * max / 2;
        int cand = sum_t - sum;
        if (cand != 0) {
            return cand;
        } else {
            if (flag) {
                return max + 1;
            } else {
                return 0;
            }
        }
    }
}