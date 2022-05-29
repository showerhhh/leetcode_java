public class t209 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t209 {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int sum = 0, minLength = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            r++;
            while (sum >= target && l < r) {  // 当窗口满足题意时，l指针左移
                minLength = Math.min(minLength, r - l);  // 判断并记录
                sum -= nums[l];
                l++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }
}