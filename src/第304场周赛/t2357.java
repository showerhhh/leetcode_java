package 第304场周赛;

import java.util.HashSet;

public class t2357 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2357 {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int hasZero = 0;
        for (int num : nums) {
            set.add(num);
            if (num == 0) {
                hasZero = 1;
            }
        }
        return set.size() - hasZero;
    }
}