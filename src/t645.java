import java.util.HashSet;

public class t645 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t645 {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int duplicate = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                duplicate = num;
            }
            max = Math.max(num, max);
            sum += num;
        }
        int correctSum = max * (max + 1) / 2;
        int drop = correctSum - (sum - duplicate);
        if (drop == 0) {
            drop = max + 1;
        }
        int[] res = new int[2];
        res[0] = duplicate;
        res[1] = drop;
        return res;
    }
}