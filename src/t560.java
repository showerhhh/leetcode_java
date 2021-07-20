public class t560 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t560 {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        // preSum[i]表示前i个数字的和（nums[0:i]包含0，不包含i）
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // 计算nums[i:j]包含i，包含j
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}