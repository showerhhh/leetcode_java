import java.util.HashMap;

public class t1 {
    public static void main(String[] args) {
        Solution_t1 solution = new Solution_t1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] tmp = solution.twoSum(nums, target);
        for (int j : tmp) {
            System.out.println(j);
        }
    }
}

class Solution_t1 {
    public int[] twoSum(int[] nums, int target) {
        int[] tmp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    tmp[0] = i;
                    tmp[1] = j;
                    return tmp;
                }
            }
        }
        return tmp;
    }

    public int[] twoSum_2(int[] nums, int target) {
        int[] tmp = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int j = map.get(target - nums[i]);
                return new int[]{i, j};
            } else {
                map.put(nums[i], i);
            }
        }
        return tmp;
    }
}