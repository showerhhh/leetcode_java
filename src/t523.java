import java.util.HashMap;

public class t523 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((preSum[j + 1] - preSum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum_2(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        // 利用同余定理优化(preSum[j + 1] - preSum[i]) % k == 0等价于preSum[j + 1] % k == preSum[i] % k
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();  // key为preSum[i]%k，value为该数第一次出现的下标
        for (int i = 0; i < preSum.length; i++) {
            int key = preSum[i] % k;
            if (!map.containsKey(key)) {
                map.put(key, i);
            } else {
                int idx = map.get(key);
                if (i - idx >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}