import java.util.HashSet;

public class t128 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int x : nums) {
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x;
            while (set.contains(y)) {
                y += 1;
            }
            maxLength = Math.max(maxLength, y - x);
        }
        return maxLength;
    }
}