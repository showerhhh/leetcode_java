package 第81场双周赛;

public class t2317 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2317 {
    public int maximumXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res |= num;
        }
        return res;
    }
}