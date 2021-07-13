import java.util.HashMap;
import java.util.HashSet;

public class t219 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = map.getOrDefault(nums[i], -1);
            if (v == -1) {
                map.put(nums[i], i);
            } else {
                if (i - v <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        // 用set维护一个大小为k的滑动窗口
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
        }
        return false;
    }
}