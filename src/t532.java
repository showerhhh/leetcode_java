import java.util.Arrays;
import java.util.HashSet;

public class t532 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t532 {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    set.add(nums[i]);
                }
            }
        }
        return set.size();
    }
}