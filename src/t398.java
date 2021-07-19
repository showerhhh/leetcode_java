import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class t398 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t398 {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    Random rand = new Random();

    public Solution_t398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        ArrayList<Integer> list = map.get(target);
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}

class Solution_t398_v2 {
    int[] nums;
    Random rand = new Random();

    public Solution_t398_v2(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        // 蓄水池算法，此处需要特殊改动的是加了count和一个判断条件
        int count = 0;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt() % count == 0) {
                    // 以1/count的概率选择这个数
                    idx = i;
                }
            }
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */