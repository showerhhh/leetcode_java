public class t209 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, minLength = nums.length + 1;
        // 外层循环控制右边界每次前进一位
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 内层循环控制左边界不断前进
            while (sum >= target) {
                int length = j - i + 1;
                // 在内层循环中，窗口符合要求，记录最小值
                minLength = Math.min(minLength, length);
                sum -= nums[i];
                i++;
            }
        }
        if (minLength == nums.length + 1) {
            return 0;
        } else {
            return minLength;
        }
    }
}